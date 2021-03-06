package com.portfolio.api.Portfolio.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "assets")
public class Asset extends Auditable<String> implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "remaining_qty")
	private double remaining_qty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
