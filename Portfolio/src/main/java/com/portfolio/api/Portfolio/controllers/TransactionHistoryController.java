package com.portfolio.api.Portfolio.controllers;


import com.portfolio.api.Portfolio.models.ResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionHistoryController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/getAllUserTransactions")
    public ResponseModel getAllUserTransactions() {
        logger.debug("Get All User Transactions API call..");
        return new ResponseModel("Sample");
    }
}
