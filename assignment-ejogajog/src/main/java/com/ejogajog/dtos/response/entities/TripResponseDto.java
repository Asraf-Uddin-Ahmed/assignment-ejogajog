package com.ejogajog.dtos.response.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TripResponseDto extends BaseEntityResponseDto {
	private double fromLatitude;
	private double fromLongitude;
	private double toLatitude;
	private double toLongitude;
}
