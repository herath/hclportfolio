package com.portfolio.api.Portfolio.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {


	@GetMapping("/summary/{userId}")
	public ResponseEntity<?> getAllPortfoliosForUser( @PathVariable String userId)
	{
		return ResponseEntity.ok(response);
	}
}
