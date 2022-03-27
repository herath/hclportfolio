package com.portfolio.api.Portfolio.service.impl;

import com.portfolio.api.Portfolio.enumerations.StatusMessages;
import com.portfolio.api.Portfolio.models.ResponseModel;
import com.portfolio.api.Portfolio.models.TransactionDetailsDto;
import com.portfolio.api.Portfolio.models.TransactionHistoryDto;
import com.portfolio.api.Portfolio.models.UserDto;
import com.portfolio.api.Portfolio.persistence.entity.Asset;
import com.portfolio.api.Portfolio.persistence.entity.AuditAction;
import com.portfolio.api.Portfolio.persistence.entity.OrderDetails;
import com.portfolio.api.Portfolio.persistence.entity.TransactionDetails;
import com.portfolio.api.Portfolio.persistence.repository.AssetRepository;
import com.portfolio.api.Portfolio.persistence.repository.AuditActionRepository;
import com.portfolio.api.Portfolio.persistence.repository.OrderDetailsRepository;
import com.portfolio.api.Portfolio.persistence.repository.TransactionDetailsRepository;
import com.portfolio.api.Portfolio.service.TransactionDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TransactionDetailsRepository transactionDetailsRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    AuditActionRepository auditActionRepository;


    @Override
    @Transactional
    public ResponseModel getAllUserTransactionsWithFilters(TransactionHistoryDto transactionHistoryDto) {

        // Checking the Order Status Value TODO implement an enum validation here..
        if (transactionHistoryDto.getOrderStatus().isBlank() || !(
                transactionHistoryDto.getOrderStatus().equals("Submitted")
                        || transactionHistoryDto.getOrderStatus().equals("Cancelled")
                        || transactionHistoryDto.getOrderStatus().equals("Executed")
                        || transactionHistoryDto.getOrderStatus().equals("Completed")
                        || transactionHistoryDto.getOrderStatus().equals("Failed"))) {
            return new ResponseModel(false, StatusMessages.INVALID_ORDER_STATUS.getStatusMessage());
        }

        // Checking the Order Status Value TODO implement an enum validation here..
        if (transactionHistoryDto.getTransactionType().isBlank() ||
                !(transactionHistoryDto.getTransactionType().toLowerCase().equals("buy")
                        || transactionHistoryDto.getTransactionType().toLowerCase().equals("sell"))) {
            return new ResponseModel(false, StatusMessages.INVALID_TRANSACTION_TYPE.getStatusMessage());
        }

        OrderDetails orderDetails = orderDetailsRepository.getByOrderRefNo(transactionHistoryDto.getOrderRefNumber());
        if (orderDetails == null || !orderDetails.getOrderRefNo().toLowerCase(Locale.ROOT)
                .equals(transactionHistoryDto.getOrderRefNumber())) {
            // Existing order ref no
            return new ResponseModel(false, StatusMessages.INVALID_ORDER_REF.getStatusMessage());
        }

        Asset asset = assetRepository.getByAssetName(transactionHistoryDto.getSecurityName());
        if (asset == null) {
            // Asset not exists
            return new ResponseModel(false, StatusMessages.INVALID_SECURITY_NAME.getStatusMessage());
        }

        // TODO Add audit log into a new function where it generated the audit string according to a logic
        AuditAction auditAction = new AuditAction("New Transaction Report is Viewed");
        auditActionRepository.save(auditAction);

        // Get data from the database table TODO update here with form and to dates.
        Iterable<TransactionDetails> trs = transactionDetailsRepository.findAll();

        List<TransactionDetailsDto> transactionDetailsDtos = new ArrayList<>();

        // Passing only relevant data for the client expose purposes
        for (TransactionDetails tansDetail : trs) {
            transactionDetailsDtos.add(convertTransactionDetailsToDto(tansDetail));
        }
        return new ResponseModel(transactionDetailsDtos);
    }

    private TransactionDetailsDto convertTransactionDetailsToDto(TransactionDetails tansDetail){
        TransactionDetailsDto transactionDetailsDto = new TransactionDetailsDto();
        transactionDetailsDto.setTransactionTime(tansDetail.getTransactionTime());
        transactionDetailsDto.setTransactionStatus(tansDetail.getTransactionStatus());
        transactionDetailsDto.setCreatedBy(new UserDto(tansDetail.getCreatedBy().getId(),
                tansDetail.getCreatedBy().getUsername()));
        transactionDetailsDto.setCreatedOn(tansDetail.getCreatedOn());
        transactionDetailsDto.setModifiedBy(new UserDto(tansDetail.getModifiedBy().getId(),
                tansDetail.getModifiedBy().getUsername()));
        transactionDetailsDto.setModifiedOn(tansDetail.getModifiedOn());
        transactionDetailsDto.setTransactionAmount(tansDetail.getTransactionAmount());
        transactionDetailsDto.setPaymentType(tansDetail.getPaymentType());
        transactionDetailsDto.setId(tansDetail.getId());
        return transactionDetailsDto;
    }

    @Scheduled(cron = "* * */24 * * *")
    public void generateTransactionReport() {
        /*
        * This method will generate the report every one hour and export report.
        * */
        // TODO implementation is left to do
        // Add the logs
    }
}
