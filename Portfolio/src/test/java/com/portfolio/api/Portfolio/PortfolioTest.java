package com.portfolio.api.Portfolio;

import com.portfolio.api.Portfolio.persistence.entity.PortfolioDetails;
import com.portfolio.api.Portfolio.persistence.entity.User;
import com.portfolio.api.Portfolio.service.PortfolioService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class PortfolioTest {

	@Autowired
	private PortfolioService portfolioService;


	@Test
	public void getAllPortfoliosForUser(){

		//create uset

		User user = new User;
		user.setId(new UUID(0L, 0L));
		user.getUsername("abc1");
		user.getPassword("1234");

		//create PortfolioDetails

		PortfolioDetails portfolioDetails = new PortfolioDetails();
		portfolioDetails.setId(new UUID(0L, 0L));
		por

		//create portfolio asset details



	}
}
