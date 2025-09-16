package com.example.demo.service;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Customer;
import com.example.demo.entity.MeterReading;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MeterReadingRepository meterReadingRepository;

    // Get all bills
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    // Get bill by ID
    public Bill getBillById(Long id) {
        return billRepository.findById(id).orElse(null);
    }

    // Create a new bill directly
    public Bill createBill(Bill bill) {
        bill.setBillingDate(LocalDate.now());
        return billRepository.save(bill);
    }

    // Generate bill from latest meter reading
    public Bill generateBillFromMeterReading(Long customerId, double ratePerUnit) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        // Get latest meter reading
        List<MeterReading> readings = meterReadingRepository.findByCustomer(customer);
        if (readings.isEmpty()) {
            throw new RuntimeException("No meter readings for this customer");
        }

        MeterReading latestReading = readings.get(readings.size() - 1); // last one
        double amount = latestReading.getUnitsConsumed() * ratePerUnit;

        Bill newBill = new Bill(amount, LocalDate.now(), customer);
        return billRepository.save(newBill);
    }
}
