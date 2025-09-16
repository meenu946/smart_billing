package com.example.demo.controller;

import com.example.demo.entity.Bill;
import com.example.demo.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillingController {

    @Autowired
    private BillingService billingService;

    // Get all bills
    @GetMapping
    public List<Bill> getAllBills() {
        return billingService.getAllBills();
    }

    // Get a single bill by ID
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        return billingService.getBillById(id);
    }

    // Create a new bill
    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billingService.createBill(bill);
    }
}
