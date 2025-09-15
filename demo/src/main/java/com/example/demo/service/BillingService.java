package com.example.demo.service;

import com.example.demo.entity.Bill;
import com.example.demo.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BillingService {

    @Autowired
    private BillRepository billRepository;

    public double calculateBill(int units) {
        double cost = 0;
        if (units <= 100) {
            cost = units * 5;
        } else if (units <= 200) {
            cost = 100 * 5 + (units - 100) * 8;
        } else {
            cost = 100 * 5 + 100 * 8 + (units - 200) * 12;
        }
        return cost;
    }

    public Bill generateBill(Long customerId, int units) {
        double amount = calculateBill(units);
        Bill bill = new Bill();
        bill.setCustomerId(customerId);
        bill.setBillingDate(LocalDate.now());
        bill.setAmount(amount);
        bill.setStatus("UNPAID");
        return billRepository.save(bill);
    }
}
