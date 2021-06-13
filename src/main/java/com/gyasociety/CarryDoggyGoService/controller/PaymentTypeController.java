package com.gyasociety.carrydoggygoservice.controller;

import com.gyasociety.carrydoggygoservice.domain.model.PaymentType;
import com.gyasociety.carrydoggygoservice.domain.service.PaymentTypeService;
import com.gyasociety.carrydoggygoservice.resource.PaymentTypeResource;
import com.gyasociety.carrydoggygoservice.resource.SavePaymentTypeResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Tag(name="PaymentTypes", description = "PaymentType API")
@RestController
@RequestMapping("/api")
public class PaymentTypeController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PaymentTypeService paymentTypeService;

    @Operation(summary = "Get All PaymentTypes", description = "Get All available PaymentTypes", responses = {
            @ApiResponse(
                    description = "All PaymentTypes",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/paymenttypes")
    public List<PaymentTypeResource> getAllPaymentTypes() {
        return paymentTypeService.getAllPaymentTypes()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
    }

    @GetMapping("/paymenttypes/{paymentTypeId}")
    public PaymentTypeResource getPaymentTypeById(@PathVariable(value = "paymentTypeId") Long paymentTypeId) {
        return convertToResource(paymentTypeService.getPaymentTypeById(paymentTypeId));
    }

    @PostMapping("/paymenttypes")
    public PaymentTypeResource createPaymentType( @Valid @RequestBody SavePaymentTypeResource resource) {

        PaymentType paymentType = convertToEntity(resource);
        return convertToResource(paymentTypeService.createPaymentType(paymentType));
    }

    @PutMapping("/paymenttypes/{paymentTypeId}")
    public PaymentTypeResource updatePaymentType(@PathVariable Long paymentTypeId,
                                             @Valid @RequestBody SavePaymentTypeResource resource) {
        PaymentType paymentType = convertToEntity(resource);
        return convertToResource(
                paymentTypeService.updatePaymentType(paymentTypeId, paymentType));
    }

    @DeleteMapping("/paymenttypes/{paymentTypeId}")
    public ResponseEntity<?> deletePaymentType(@PathVariable Long paymentTypeId) {
        return paymentTypeService.deletePaymentType(paymentTypeId);
    }

    private PaymentType convertToEntity(SavePaymentTypeResource resource) {
        return mapper.map(resource, PaymentType.class);
    }

    private PaymentTypeResource convertToResource(PaymentType entity) {
        return mapper.map(entity, PaymentTypeResource.class);
    }
}
