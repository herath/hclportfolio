package com.portfolio.api.Portfolio.service;

import com.portfolio.api.Portfolio.models.ResponseModel;
import com.portfolio.api.Portfolio.models.TransactionHistoryDto;

public interface TransactionDetailsService {

    ResponseModel getAllUserTransactionsWithFilters(TransactionHistoryDto transactionHistoryDto);
}
