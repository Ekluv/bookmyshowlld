package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Auditorium extends BaseModel {
    private String name;

    @ManyToOne
    private Threatre threatre;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
    @OneToMany(mappedBy = "auditorium")
    private List<Show> shows;
    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;
}
