package com.portfolio.api.Portfolio.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "portfolio_asset_details")
public class PortfolioAssetDetails implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable=false)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private User name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
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
