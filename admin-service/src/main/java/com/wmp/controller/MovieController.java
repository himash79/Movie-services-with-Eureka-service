package com.wmp.controller;

import com.wmp.entity.Movie;
import com.wmp.repository.MovieRepository;
import com.wmp.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequiredArgsConstructor
@CrossOrigin
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies/insertMovie")
    public ResponseEntity<?> insertMovie(@RequestBody Movie dto){
        return movieService.insertMovie(dto);
    }

    @PutMapping("/movies/updateMovie/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable int id, @RequestBody Movie dto){
        return movieService.updateMovie(id, dto);
    }

    @PatchMapping("/movies/updateMovie/{id}")
    public ResponseEntity<?> updateMoviePatch(@PathVariable int id, @RequestBody Movie dto){
        return movieService.updateMovie(id, dto);
    }

}
