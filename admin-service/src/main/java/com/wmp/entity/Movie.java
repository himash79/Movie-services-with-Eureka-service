package com.wmp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "min_movie")
@Entity
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATED")
    private String created;

    @Column(name = "SPECIES")
    private String species;

    @Column(name = "URL")
    private String url;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "IMAGE")
    private String movieImage;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ORIGIN_ID", referencedColumnName = "ID", nullable = false)
    private Origin origin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID", nullable = false)
    private Location location;

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movie")
    private Set<Episode> episodes;

    public Movie(int id) {
        this.id = id;
    }

    public Movie(String status, String name, String created, String species, String url, String type, String gender, String movieImage, Origin origin, Location location, Set<Episode> episodes) {
        this.status = status;
        this.name = name;
        this.created = created;
        this.species = species;
        this.url = url;
        this.type = type;
        this.gender = gender;
        this.movieImage = movieImage;
        this.origin = origin;
        this.location = location;
        this.episodes = episodes;
    }
}
