package com.portfolio.api.Portfolio.controllers;

import com.portfolio.api.Portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;

	@GetMapping("/summary/{userId}")
	public ResponseEntity<?> getAllPortfoliosForUser( @PathVariable UUID userId)
	{
		return ResponseEntity.ok(portfolioService.getAllPortfoliosForUser(userId));
	}
}
