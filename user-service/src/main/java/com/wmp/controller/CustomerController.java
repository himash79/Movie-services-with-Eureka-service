package com.wmp.controller;

import com.wmp.dto.CustomerDto;
import com.wmp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
@RequiredArgsConstructor
@CrossOrigin
public class CustomerController {

    private final CustomerService customerService;

    @PutMapping("/customers/updateCustomer/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody CustomerDto dto){
        return customerService.updateCustomer(id, dto);
    }

}
