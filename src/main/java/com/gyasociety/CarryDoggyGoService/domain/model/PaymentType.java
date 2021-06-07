package com.gyasociety.CarryDoggyGoService.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="payment_types")
public class PaymentType extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;

    //    --------------------
    public Long getId() {
        return id;
    }

    public PaymentType setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PaymentType setName(String name) {
        this.name = name;
        return this;
    }
}
