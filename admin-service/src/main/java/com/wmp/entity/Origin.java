package com.wmp.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "min_movie_origin")
@Entity
@ToString
public class Origin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    @OneToOne(mappedBy = "origin")
    private Movie movie;

    @Column(name = "ORIGIN_NAME")
    private String originName;

    @Column(name = "ORIGIN_URL")
    private String originUrl;

    public Origin(String originName, String originUrl) {
        this.originName = originName;
        this.originUrl = originUrl;
    }
}
