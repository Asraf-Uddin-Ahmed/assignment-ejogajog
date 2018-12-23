package com.ejogajog.dtos.mapper.errors;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.ejogajog.dtos.response.errors.CsvValidationErrorResponseDto;

public interface CsvValidationErrorMapper {

	CsvValidationErrorResponseDto addValidationErrors(Set<ConstraintViolation<Object>> constraintViolations, int row);

}