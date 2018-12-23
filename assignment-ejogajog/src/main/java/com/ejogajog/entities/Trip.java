package com.ejogajog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Trip extends BaseEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private long id;

	@NotNull
	private double fromLatitude;

	@NotNull
	private double fromLongitude;

	@NotNull
	private double toLatitude;

	@NotNull
	private double toLongitude;

}
