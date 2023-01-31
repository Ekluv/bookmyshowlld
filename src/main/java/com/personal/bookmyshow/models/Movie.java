package com.personal.bookmyshow.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Movie extends BaseModel {
    private String name;
    private Date releaseDate;
    @ManyToMany
    private List<Actor> actors;

}
