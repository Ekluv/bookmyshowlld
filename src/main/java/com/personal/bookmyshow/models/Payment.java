package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Payment extends BaseModel {
    private String vendorId;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @ManyToOne
    private Ticket ticket;
}
