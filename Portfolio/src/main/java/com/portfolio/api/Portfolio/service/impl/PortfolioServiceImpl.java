package com.portfolio.api.Portfolio.service.impl;

import com.portfolio.api.Portfolio.UserNotFoundException;
import com.portfolio.api.Portfolio.dto.PortfolioResponse;
import com.portfolio.api.Portfolio.persistence.entity.PortfolioAssetDetails;
import com.portfolio.api.Portfolio.persistence.entity.PortfolioDetails;
import com.portfolio.api.Portfolio.persistence.entity.User;
import com.portfolio.api.Portfolio.persistence.repository.PortfolioAssetDetailsRepository;
import com.portfolio.api.Portfolio.persistence.repository.PortfolioDetailsRepository;
import com.portfolio.api.Portfolio.persistence.repository.UserRepository;
import com.portfolio.api.Portfolio.service.PortfolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	private PortfolioDetailsRepository portfolioDetailsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PortfolioAssetDetailsRepository portfolioAssetDetailsRepository;

	@Override
	public PortfolioResponse getAllPortfoliosForUser(UUID userId) {
		Optional<User> user =  userRepository.findById(userId);
		if(user.isPresent()){
			PortfolioDetails portfolioDetails = portfolioDetailsRepository.findByUser(user.get());
			List<PortfolioAssetDetails> portfolioAssetDetails = portfolioAssetDetailsRepository.findByUser(user.get());
		}
		else{
			log.error("User not found!");
			throw new UserNotFoundException();
		}
		return null;
	}
}
