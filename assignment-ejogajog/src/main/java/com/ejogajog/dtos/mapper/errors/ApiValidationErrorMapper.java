package com.ejogajog.dtos.mapper.errors;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.ejogajog.dtos.mapper.DtoMapper;
import com.ejogajog.dtos.response.errors.ApiValidationErrorResponseDto;

public interface ApiValidationErrorMapper extends DtoMapper {

	ApiValidationErrorResponseDto getApiValidationError(ConstraintViolation<?> constraintViolation);

	List<ApiValidationErrorResponseDto> getApiValidationErrors(Set<ConstraintViolation<?>> constraintViolations);

	List<ApiValidationErrorResponseDto> getApiValidationErrorsOfType(
			Set<ConstraintViolation<Object>> constraintViolations);

	ApiValidationErrorResponseDto getApiValidationError(FieldError fieldError);

	ApiValidationErrorResponseDto getApiValidationError(ObjectError objectError);

}