package com.wmp.repository;

import com.wmp.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query("SELECT u FROM Admin u WHERE u.username = :username")
    Admin findByUserName(@Param("username") String username);

}
