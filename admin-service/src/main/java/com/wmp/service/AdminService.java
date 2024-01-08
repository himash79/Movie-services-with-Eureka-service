package com.wmp.service;

import com.wmp.dto.AdminDto;
import com.wmp.entity.Admin;
import com.wmp.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseEntity<?> insertAdmin(AdminDto dto) {
        Admin model = new Admin();
        try {
            String encPassword = passwordEncoder.encode(dto.getPassword());
            dto.setPassword(encPassword);
            BeanUtils.copyProperties(dto, model);
            log.info("Admin model : " + model);
            adminRepository.save(model);
            return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("admin service impl | insertAdmin() | Error found" + e);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }
}
