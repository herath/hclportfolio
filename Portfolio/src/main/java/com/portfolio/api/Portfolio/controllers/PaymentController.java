package com.portfolio.api.Portfolio.controllers;

import com.portfolio.api.Portfolio.models.PaymentRequest;
import com.portfolio.api.Portfolio.models.PaymentResponse;
import com.portfolio.api.Portfolio.models.ResponseModel;
import com.portfolio.api.Portfolio.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/makePayment")
    public ResponseModel makePayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        logger.info("paymentResponse - " + paymentRequest);
        PaymentResponse paymentResponse = paymentService.makePayment();
        return new ResponseModel("Sample");
    }

}
