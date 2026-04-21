package de.dhbw.ravensburg.wp.mymoviedatabase.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class StreamingPlatform {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private double subscriptionPrice;

    private boolean hasStudentDiscount;

    @ManyToMany()
    @JoinTable(name = "platform_movies",
            joinColumns = {
                    @JoinColumn(name = "platform_id", referencedColumnName = "id",
                            updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "movie_id", referencedColumnName = "id",
                            updatable = false)})
    private List<Movie> movies;

    public StreamingPlatform(String name, double subscriptionPrice, boolean hasStudentDiscount){
        this.name = name;
        this.subscriptionPrice = subscriptionPrice;
        this.hasStudentDiscount = hasStudentDiscount;
    }




}
