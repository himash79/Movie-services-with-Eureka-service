package com.wmp.repository;

import com.wmp.entity.Customer;
import com.wmp.entity.CustomerMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CustomerMovieRepository extends JpaRepository<CustomerMovie, Integer> {
}
