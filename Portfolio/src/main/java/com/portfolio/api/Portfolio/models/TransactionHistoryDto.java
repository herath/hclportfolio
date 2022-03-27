package com.portfolio.api.Portfolio.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class TransactionHistoryDto implements Serializable {

    @NotBlank(message = "Order Reference is mandatory")
    @Size(min=3, max=40)
    private String orderRefNumber;

    @NotBlank(message = "Security Name is mandatory")
    @Size(min=3, max=250)
    private String securityName;

    private String transactionType;

    @NotBlank(message = "Order Status Name is mandatory")
    @Size(min=3, max=50)
    private String orderStatus;

    @NotBlank(message = "From Date is mandatory")
    private String fromDate;

    @NotBlank(message = "To Date is mandatory")
    private String toDate;

    public String getOrderRefNumber() {
        return orderRefNumber;
    }

    public void setOrderRefNumber(String orderRefNumber) {
        this.orderRefNumber = orderRefNumber;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }
}