package com.portfolio.api.Portfolio.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class TransactionDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private OrderDetails orderDetails;

    private BigDecimal transactionAmount;

    private String paymentType;

    private Date transactionTime;

    private String transactionStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private User modifiedBy;

    private Date createdOn;

    private Date modifiedOn;




}
