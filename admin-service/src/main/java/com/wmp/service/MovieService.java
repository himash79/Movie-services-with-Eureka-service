package com.wmp.service;

import com.wmp.entity.Episode;
import com.wmp.entity.Movie;
import com.wmp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {

    private final MovieRepository movieRepository;

    public ResponseEntity<?> insertMovie(Movie dto) {

        try {
            for(Episode e : dto.getEpisodes()) {
                e.setMovie(dto);
            }
            log.info("Movie model : " + dto);
            movieRepository.save(dto);
            return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("movie service impl | insertMovie() | Error found" + e);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }

    public ResponseEntity<?> updateMovie(int id, Movie dto) {
        try {
            Boolean checkAvailable = movieRepository.findById(id).isPresent();
            if (Boolean.TRUE.equals(checkAvailable)) {
                Movie oldMovie = movieRepository.findById(id).get();
                // set oldmovie obj to save
                Movie newMovie = this.copy(dto, oldMovie);
                movieRepository.save(newMovie);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Object not found !", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    /////// INTERNAL METHODS ///////
    private Movie copy(Movie newModel, Movie oldModel) {
        if (newModel.getStatus() != null) {
            oldModel.setStatus(newModel.getStatus());
        }
        if (newModel.getName() != null) {
            oldModel.setName(newModel.getName());
        }
        if (newModel.getSpecies() != null) {
            oldModel.setSpecies(newModel.getSpecies());
        }
        if (newModel.getUrl() != null) {
            oldModel.setUrl(newModel.getUrl());
        }
        if (newModel.getType() != null) {
            oldModel.setType(newModel.getType());
        }
        if (newModel.getGender() != null) {
            oldModel.setGender(newModel.getGender());
        }
        if (newModel.getOrigin() != null) {
            if (newModel.getOrigin().getOriginName() != null) {
                oldModel.getOrigin().setOriginName(newModel.getOrigin().getOriginName());
            }
            if (newModel.getOrigin().getOriginUrl() != null) {
                oldModel.getOrigin().setOriginUrl(newModel.getOrigin().getOriginUrl());
            }
        }
        if (newModel.getMovieImage() != null) {
            oldModel.setMovieImage(newModel.getMovieImage());
        }
        if (newModel.getLocation() != null) {
            if (newModel.getLocation().getLocationName() != null) {
                oldModel.getLocation().setLocationName(newModel.getLocation().getLocationName());
            }
            if (newModel.getLocation().getLocationUrl() != null) {
                oldModel.getLocation().setLocationUrl(newModel.getLocation().getLocationUrl());
            }
        }
        return oldModel;
    }
}
