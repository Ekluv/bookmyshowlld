package com.personal.bookmyshow.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseModel {
    @ManyToOne
    private Show show;
    @OneToMany(mappedBy = "ticket")
    private List<Payment> payment;
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;
    @ManyToMany
    private List<ShowSeat> bookedSeats;
    private double amount;
}
