package com.wmp.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "min_episode")
@Entity
@ToString
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private int id;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private Movie movie;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "URL")
    private String url;

    public Episode(String name, String status, String url) {
        this.name = name;
        this.status = status;
        this.url = url;
    }
}
