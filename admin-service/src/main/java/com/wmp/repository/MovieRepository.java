package com.wmp.repository;

import com.wmp.entity.Movie;
import com.wmp.entity.projections.MovieBasicProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
