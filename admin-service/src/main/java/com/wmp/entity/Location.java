package com.wmp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "min_movie_location")
@Entity
@ToString
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    @OneToOne(mappedBy = "location")
    private Movie movie;

    @Column(name = "LOCATION_NAME")
    private String locationName;

    @Column(name = "LOCATION_URL")
    private String locationUrl;

    public Location(String locationName, String locationUrl) {
        this.locationName = locationName;
        this.locationUrl = locationUrl;
    }
}
