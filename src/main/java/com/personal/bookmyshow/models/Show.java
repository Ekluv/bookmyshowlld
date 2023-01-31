package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="movie_show")
public class Show extends BaseModel {
    Date startTime;
    Date endTime;
    @ManyToOne
    Auditorium auditorium;
    @ManyToOne
    Movie movie;
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;

}
