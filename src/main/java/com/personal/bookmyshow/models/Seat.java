package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name="movie_seat")
public class Seat extends BaseModel {
    @ManyToOne
    private Auditorium auditorium;
    private int seatRow;
    private int seatCol;
    private String name;
    @ManyToOne
    private SeatType seatType;
}
