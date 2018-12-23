package com.ejogajog.dtos.mapper.errors;

import org.springframework.http.HttpStatus;

import com.ejogajog.dtos.mapper.errors.persistence.ApiErrorMapperImpl;
import com.ejogajog.dtos.response.errors.ApiErrorResponseDto;

public interface ApiErrorMapper {

	ApiErrorMapperImpl initDefaultValidationError();

	ApiErrorMapperImpl setStatus(HttpStatus status);

	ApiErrorMapperImpl setMessage(String message);

	ApiErrorMapperImpl setDebugMessage(Throwable exception);

	ApiErrorMapper initResponseDto();

	ApiErrorResponseDto build();

}