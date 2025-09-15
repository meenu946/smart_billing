package com.example.demo.controller;

import com.example.demo.entity.Bill;
import com.example.demo.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    // Generate bill for a customer
    @PostMapping("/generate/{customerId}/{units}")
    public Bill generateBill(@PathVariable Long customerId, @PathVariable int units) {
        return billingService.generateBill(customerId, units);
    }

    // Test endpoint
    @GetMapping("/hello")
    public String hello() {
        return "Smart Utility Billing System is running!";
    }
}
