package com.gyasociety.carrydoggygoservice.service;

import com.gyasociety.carrydoggygoservice.domain.model.PaymentType;
import com.gyasociety.carrydoggygoservice.domain.repository.PaymentTypeRepository;
import com.gyasociety.carrydoggygoservice.domain.service.PaymentTypeService;
import com.gyasociety.carrydoggygoservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> getAllPaymentTypes() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType getPaymentTypeById(Long paymentTypeId) {
        return paymentTypeRepository.findById(paymentTypeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PaymentType", "Id", paymentTypeId));
    }

    @Override
    public PaymentType createPaymentType(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public PaymentType updatePaymentType(Long paymentTypeId, PaymentType paymentTypeRequest) {
        PaymentType paymentType = paymentTypeRepository.findById(paymentTypeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PaymentType", "Id", paymentTypeId));

        return paymentTypeRepository.save(
                paymentType.setName(paymentTypeRequest.getName())
        );
    }

    @Override
    public ResponseEntity<?> deletePaymentType(Long paymentTypeId) {
        PaymentType paymentType = paymentTypeRepository.findById(paymentTypeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PaymentType", "Id", paymentTypeId));
        paymentTypeRepository.delete(paymentType);
        return ResponseEntity.ok().build();
    }
}
