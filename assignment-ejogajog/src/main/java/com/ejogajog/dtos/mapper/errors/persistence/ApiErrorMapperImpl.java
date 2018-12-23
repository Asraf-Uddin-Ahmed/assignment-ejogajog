package com.ejogajog.dtos.mapper.errors.persistence;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.ejogajog.dtos.mapper.errors.ApiErrorMapper;
import com.ejogajog.dtos.mapper.persistence.DtoMapperImpl;
import com.ejogajog.dtos.response.errors.ApiErrorResponseDto;

@Component
@Scope(value = "prototype")
public class ApiErrorMapperImpl extends DtoMapperImpl implements ApiErrorMapper {

	private ApiErrorResponseDto apiErrorResponseDto;

	@Autowired
	protected ApiErrorMapperImpl(ModelMapper modelMapper) {
		super(modelMapper);
	}

	public ApiErrorMapperImpl initDefaultValidationError() {
		this.apiErrorResponseDto.setStatus(HttpStatus.BAD_REQUEST);
		this.apiErrorResponseDto.setMessage("Validation error");
		return this;
	}

	public ApiErrorMapperImpl setStatus(HttpStatus status) {
		this.apiErrorResponseDto.setStatus(status);
		return this;
	}

	public ApiErrorMapperImpl setMessage(String message) {
		this.apiErrorResponseDto.setMessage(message);
		return this;
	}

	public ApiErrorMapperImpl setDebugMessage(Throwable exception) {
		this.apiErrorResponseDto.setDebugMessage(exception.getLocalizedMessage());
		return this;
	}

	public ApiErrorMapper initResponseDto() {
		this.apiErrorResponseDto = new ApiErrorResponseDto();
		return this;
	}

	public ApiErrorResponseDto build() {
		return this.apiErrorResponseDto;
	}

}
