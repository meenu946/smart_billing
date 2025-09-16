package com.example.demo.repository;

import com.example.demo.entity.Bill;
import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    // Example: Find bills by customer
    List<Bill> findByCustomer(Customer customer);
}
