package com.wmp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private int id;
    private String status;
    private String name;
    private String created;
    private String species;
    private String url;
    private String type;
    private String gender;
    private OriginDto origin;
    private String image;
    private LocationDto location;
    private List<String> episode;

}
