package com.portfolio.api.Portfolio.service.impl;

import com.portfolio.api.Portfolio.models.ResponseModel;
import com.portfolio.api.Portfolio.models.TransactionHistoryDto;
import com.portfolio.api.Portfolio.persistence.entity.TransactionDetails;
import com.portfolio.api.Portfolio.persistence.repository.TransactionDetailsRepository;
import com.portfolio.api.Portfolio.service.TransactionDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

    @Autowired
    TransactionDetailsRepository transactionDetailsRepository;


    @Override
    public ResponseModel getAllUserTransactionsWithFilters(TransactionHistoryDto transactionHistoryDto) {
        Iterable<TransactionDetails> trs = transactionDetailsRepository.findAll();
        return new ResponseModel(trs);
    }
}
