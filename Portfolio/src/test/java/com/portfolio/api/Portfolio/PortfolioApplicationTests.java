package com.portfolio.api.Portfolio;

import com.portfolio.api.Portfolio.enumerations.StatusMessages;
import com.portfolio.api.Portfolio.models.ResponseModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PortfolioApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void checkTransactionType() {
		// Testing positive response message
		ResponseModel responseModel = new ResponseModel(true);
		assertThat(responseModel).isNotNull();
		assertThat(responseModel.isStatus()).isTrue();
		Assert.hasText(
				responseModel.getStatusMessage(),
				StatusMessages.SUCCESS.getStatusMessage());

		// Testing negative response message
		responseModel = new ResponseModel(false);
		assertThat(responseModel).isNotNull();
		assertThat(responseModel.isStatus()).isFalse();
		Assert.hasText(
				responseModel.getStatusMessage(),
				StatusMessages.ERROR_OCCURRED.getStatusMessage());
	}

}
