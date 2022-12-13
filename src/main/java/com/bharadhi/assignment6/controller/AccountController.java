package com.bharadhi.assignment6.controller;

import com.bharadhi.assignment6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/credit/{v}")
    public  String credit(@PathVariable BigDecimal v) {
        accountService.credit(v);
        return "credit=" + v;
    }
    @RequestMapping("/debit/{v1}")
    public String debit(@PathVariable BigDecimal v1){
        accountService.debit(v1);
        return "debit="+v1;
    }
    @RequestMapping("/display")
    public String display(){
        return accountService.display();

    }

}
