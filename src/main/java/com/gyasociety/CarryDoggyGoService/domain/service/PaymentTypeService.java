package com.gyasociety.carrydoggygoservice.domain.service;

import com.gyasociety.carrydoggygoservice.domain.model.PaymentType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentTypeService {

    List<PaymentType> getAllPaymentTypes();
    PaymentType getPaymentTypeById(Long paymentTypeId);
    PaymentType createPaymentType(PaymentType paymentType);
    PaymentType updatePaymentType(Long paymentTypeId, PaymentType paymentTypeRequest);
    ResponseEntity<?> deletePaymentType(Long paymentTypeId);
}
