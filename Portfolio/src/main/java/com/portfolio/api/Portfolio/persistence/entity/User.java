package com.portfolio.api.Portfolio.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User extends Auditable<String> implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable=false)
	private UUID id;

	@Column(name = "username", unique = true, nullable=false)
	private String username;

	@Column(name = "password")
	private String password;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
