package com.example.demo.repository;

import com.example.demo.entity.MeterReading;
import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {
    // Example: Find readings by customer
    List<MeterReading> findByCustomer(Customer customer);
}
