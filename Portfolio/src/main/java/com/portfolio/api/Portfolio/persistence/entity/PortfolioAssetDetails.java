package com.portfolio.api.Portfolio.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "portfolio_asset_details")
public class PortfolioAssetDetails {
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable=false)
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_fk"))
	private User name;

	@OneToMany
	@JoinColumn(name = "asset_id", foreignKey = @ForeignKey(name = "asset_fk"))
	private Asset asset;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getName() {
		return name;
	}

	public void setName(User name) {
		this.name = name;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}
}
