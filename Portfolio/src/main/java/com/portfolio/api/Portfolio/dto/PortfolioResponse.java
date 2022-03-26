package com.portfolio.api.Portfolio.dto;

import com.portfolio.api.Portfolio.persistence.entity.Asset;

import java.util.List;

public class PortfolioResponse {

	private double runningBalance;

	private List<Asset> assets;
}
