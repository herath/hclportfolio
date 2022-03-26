package com.portfolio.api.Portfolio.service;

import com.portfolio.api.Portfolio.dto.PortfolioResponse;

import java.util.UUID;

public interface PortfolioService {

	PortfolioResponse getAllPortfoliosForUser(UUID userId);
}
