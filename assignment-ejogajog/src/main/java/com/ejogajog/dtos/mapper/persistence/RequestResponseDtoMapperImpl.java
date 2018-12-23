package com.ejogajog.dtos.mapper.persistence;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import com.ejogajog.dtos.mapper.RequestResponseDtoMapper;
import com.ejogajog.dtos.request.BaseRequestDto;
import com.ejogajog.dtos.response.entities.BaseEntityResponseDto;
import com.ejogajog.entities.BaseEntity;

public abstract class RequestResponseDtoMapperImpl<TEntity extends BaseEntity, TResponseDto extends BaseEntityResponseDto, TRequestDto extends BaseRequestDto>
		extends ResponseDtoMapperImpl<TEntity, TResponseDto>
		implements RequestResponseDtoMapper<TEntity, TResponseDto, TRequestDto> {

	private final Class<TEntity> tEntityType;

	protected RequestResponseDtoMapperImpl(final ModelMapper modelMapper, final Class<TResponseDto> responseDtoType,
			final Class<TEntity> entityType) {
		super(modelMapper, responseDtoType);
		this.tEntityType = entityType;
	}

	public TEntity getEntity(final TRequestDto requestDto) {
		return modelMapper.map(requestDto, tEntityType);
	}

	public void loadEntity(final TRequestDto requestDto, final TEntity entity) {
		modelMapper.map(requestDto, entity);
	}

	protected final RequestResponseDtoMapperImpl<TEntity, TResponseDto, TRequestDto> setRequestToEntityPropertyMap(
			final PropertyMap<TRequestDto, TEntity> requestToEntityPropertyMap) {
		if (requestToEntityPropertyMap != null) {
			this.modelMapper.addMappings(requestToEntityPropertyMap);
		}
		return this;
	}

}
