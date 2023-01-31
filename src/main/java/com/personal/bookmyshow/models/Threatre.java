package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Threatre extends BaseModel {
    private String name;
    private String address;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "threatre")
    private List<Auditorium> auditoriums;
}
