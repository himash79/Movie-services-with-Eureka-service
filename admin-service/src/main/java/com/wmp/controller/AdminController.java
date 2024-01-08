package com.wmp.controller;

import com.wmp.dto.AdminDto;
import com.wmp.repository.AdminRepository;
import com.wmp.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RepositoryRestController
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/admins/insertAdmin")
    public ResponseEntity<?> insertAdmin(@RequestBody AdminDto dto){
        return adminService.insertAdmin(dto);
    }

}
