package com.portfolio.api.Portfolio.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "portfolio_details")
public class PortfolioDetails extends Auditable<String> {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable=false)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_fk"))
	private User user;

	@Column(name = "runnable_balance")
	private double runnableBalance;
}
