package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class City extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "city")
    private List<Threatre> theatres;
}
