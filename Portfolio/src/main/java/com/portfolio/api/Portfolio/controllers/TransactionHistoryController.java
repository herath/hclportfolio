package com.portfolio.api.Portfolio.controllers;


import com.portfolio.api.Portfolio.models.ResponseModel;
import com.portfolio.api.Portfolio.models.TransactionHistoryDto;
import com.portfolio.api.Portfolio.service.TransactionDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionHistoryController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TransactionDetailsService transactionDetailsService;

    @GetMapping(value = "/getAllUserTransactions")
    public ResponseModel getAllUserTransactions() {
        logger.debug("Get All User Transactions API call..");
        return new ResponseModel("Sample");
    }

    @PostMapping(value = "/getAllUserTransactionsWithFilters")
    public ResponseModel getAllUserTransactionsWithFilters(@Valid  @RequestBody TransactionHistoryDto transactionHistoryDto) {
        logger.debug("Get All User Transactions API call..");
        return transactionDetailsService.getAllUserTransactionsWithFilters(transactionHistoryDto);
    }



}
