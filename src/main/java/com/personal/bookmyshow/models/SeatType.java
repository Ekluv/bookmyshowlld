package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class SeatType extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "seatType")
    private List<Seat> seats;
}
