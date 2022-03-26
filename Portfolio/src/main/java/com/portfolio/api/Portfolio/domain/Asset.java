package com.portfolio.api.Portfolio.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "assets")
public class Asset {
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable=false)
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "remaining_qty")
	private double remaining_qty;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRemaining_qty() {
		return remaining_qty;
	}

	public void setRemaining_qty(double remaining_qty) {
		this.remaining_qty = remaining_qty;
	}
}
