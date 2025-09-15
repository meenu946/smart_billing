package com.example.demo.repository;

import com.example.demo.entity.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {}
