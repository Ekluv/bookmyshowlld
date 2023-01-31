package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Actor extends BaseModel {
    private String name;
    @ManyToMany
    private List<Movie> movies;
}
