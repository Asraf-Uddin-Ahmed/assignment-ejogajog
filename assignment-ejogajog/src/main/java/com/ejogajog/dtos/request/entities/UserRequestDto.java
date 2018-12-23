package com.ejogajog.dtos.request.entities;

import javax.validation.constraints.NotBlank;

import com.ejogajog.dtos.request.BaseRequestDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserRequestDto extends BaseRequestDto {
	@NotBlank
	private String email;

	@NotBlank
	private String password;
}
