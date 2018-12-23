package com.ejogajog.dtos.request.entities;

import javax.validation.constraints.NotNull;

import com.ejogajog.dtos.request.BaseRequestDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TripRequestDto extends BaseRequestDto {
	@NotNull
	private Double fromLatitude;

	@NotNull
	private Double fromLongitude;

	@NotNull
	private Double toLatitude;

	@NotNull
	private Double toLongitude;
}
