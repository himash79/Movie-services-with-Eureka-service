package com.wmp.controller;

import com.wmp.dto.CustomerMovieDto;
import com.wmp.service.CustomerMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RepositoryRestController
@CrossOrigin
public class CustomerMovieController {

    private final CustomerMovieService customerMovieService;

    @PostMapping("/customerMovies/purchase")
    public ResponseEntity<?> purchase(@RequestBody CustomerMovieDto dto){
        return customerMovieService.insertCustomerMovie(dto);
    }
}
