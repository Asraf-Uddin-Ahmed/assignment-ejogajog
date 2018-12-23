package com.ejogajog.dtos.mapper;

import com.ejogajog.dtos.request.BaseRequestDto;
import com.ejogajog.dtos.response.entities.BaseEntityResponseDto;
import com.ejogajog.entities.BaseEntity;

public interface RequestResponseDtoMapper<TEntity extends BaseEntity, TResponseDto extends BaseEntityResponseDto, TRequestDto extends BaseRequestDto>
		extends ResponseDtoMapper<TEntity, TResponseDto> {

	TEntity getEntity(TRequestDto requestDto);

	void loadEntity(TRequestDto requestDto, TEntity entity);

}
