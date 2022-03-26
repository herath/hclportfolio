package com.portfolio.api.Portfolio.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "portfolio_details")
public class PortfolioDetails {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable=false)
	private UUID id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private User user;

	@Column(name = "runnable_balance")
	private double runnableBalance;

	private Date timestamp;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getRunnableBalance() {
		return runnableBalance;
	}

	public void setRunnableBalance(double runnableBalance) {
		this.runnableBalance = runnableBalance;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
