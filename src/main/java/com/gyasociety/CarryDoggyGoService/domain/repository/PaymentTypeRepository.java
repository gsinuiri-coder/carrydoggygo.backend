package com.gyasociety.carrydoggygoservice.domain.repository;

import com.gyasociety.carrydoggygoservice.domain.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
