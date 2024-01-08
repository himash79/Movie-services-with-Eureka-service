package com.wmp.entity.projections;

import com.wmp.entity.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "MovieBasicDetails", types = { Movie.class })
public interface MovieBasicProjection {

    int getId();
    String getName();

    @Value("#{(target.getGender())}")
    String getGender();

}
