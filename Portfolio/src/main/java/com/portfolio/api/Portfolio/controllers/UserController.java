package com.portfolio.api.Portfolio.controllers;

import com.portfolio.api.Portfolio.models.ResponseModel;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/test")
    public ResponseModel test() {
        // logger.debug("Test API call..");
        System.out.println("Loggin in sysout 1");
        return new ResponseModel(true);
    }

}
