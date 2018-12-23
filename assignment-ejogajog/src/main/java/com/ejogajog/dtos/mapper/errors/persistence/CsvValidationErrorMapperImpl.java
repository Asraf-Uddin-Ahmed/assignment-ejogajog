package com.ejogajog.dtos.mapper.errors.persistence;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ejogajog.dtos.mapper.errors.ApiValidationErrorMapper;
import com.ejogajog.dtos.mapper.errors.CsvValidationErrorMapper;
import com.ejogajog.dtos.mapper.persistence.DtoMapperImpl;
import com.ejogajog.dtos.response.errors.CsvValidationErrorResponseDto;

@Component
@Scope(value = "prototype")
public class CsvValidationErrorMapperImpl extends DtoMapperImpl implements CsvValidationErrorMapper {

	private final ApiValidationErrorMapper apiValidationErrorMapper;

	@Autowired
	protected CsvValidationErrorMapperImpl(ModelMapper modelMapper, ApiValidationErrorMapper apiValidationErrorMapper) {
		super(modelMapper);
		this.apiValidationErrorMapper = apiValidationErrorMapper;
	}

	public CsvValidationErrorResponseDto addValidationErrors(Set<ConstraintViolation<Object>> constraintViolations,
			int row) {
		CsvValidationErrorResponseDto response = new CsvValidationErrorResponseDto(row);
		response.setErrors(this.apiValidationErrorMapper.getApiValidationErrorsOfType(constraintViolations));
		if (response.hasErrors()) {
			return response;
		}
		return null;
	}

}
