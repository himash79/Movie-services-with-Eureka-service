package com.wmp.service;

import com.wmp.dto.CustomerMovieDto;
import com.wmp.entity.Customer;
import com.wmp.entity.CustomerMovie;
import com.wmp.entity.Movie;
import com.wmp.repository.CustomerMovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerMovieService {

    private final CustomerMovieRepository customerMovieRepository;

    public ResponseEntity<?> insertCustomerMovie(CustomerMovieDto dto) {
        CustomerMovie cm = new CustomerMovie();
        Customer c = new Customer();
        Movie m = new Movie();
        try {
            BeanUtils.copyProperties(dto, cm);
            m.setId(dto.getMovieId());
            cm.setMovie(m);
            c.setId(dto.getCustomerId());
            cm.setCustomer(c);
            cm.setDateTime(LocalDateTime.now().toString());
            log.info("Customer Movie model : " + cm);
            customerMovieRepository.save(cm);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
