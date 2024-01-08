package com.wmp.service;


import com.wmp.dto.CustomerDto;
import com.wmp.entity.Customer;
import com.wmp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public ResponseEntity<?> updateCustomer(int id, CustomerDto dto) {

        try {
            Boolean checkAvailable = customerRepository.findById(id).isPresent();
            if (Boolean.TRUE.equals(checkAvailable)) {
                Customer oldCu = customerRepository.findById(id).get();
                Customer newCu = this.copy(dto, oldCu);
                customerRepository.save(newCu);
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
    private Customer copy(CustomerDto newModel, Customer oldModel) {
        if (newModel.getFirstName() != null) {
            oldModel.setFirstName(newModel.getFirstName());
        }
        if (newModel.getLastName() != null) {
            oldModel.setLastName(newModel.getLastName());
        }
        if (newModel.getEmail() != null) {
            oldModel.setEmail(newModel.getEmail());
        }
        if (newModel.getContactNumber() != null) {
            oldModel.setContactNumber(newModel.getContactNumber());
        }
        if (newModel.getUsername() != null) {
            oldModel.setUsername(newModel.getUsername());
        }
        if (newModel.getPassword() != null) {
            oldModel.setPassword(newModel.getPassword());
        }
        if (newModel.getStatus() != null) {
            oldModel.setStatus(newModel.getStatus());
        }

        return oldModel;
    }

}
