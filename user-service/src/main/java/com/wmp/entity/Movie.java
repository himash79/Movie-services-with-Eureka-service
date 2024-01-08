package com.wmp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "min_movie")
@Entity
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "ORIGIN_NAME")
    private String originName;

    @Column(name = "ORIGIN_URL")
    private String originUrl;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "LOCATION_NAME")
    private String locationName;

    @Column(name = "LOCATION_URL")
    private String locationUrl;

}
