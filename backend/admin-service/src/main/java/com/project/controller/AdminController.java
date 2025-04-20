package com.project.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.dto.AdminDTO;
import com.project.request.AdminRequest;
import com.project.response.AdminResponse;
import com.project.service.AdminService;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin("http://localhost:3000")
public class AdminController {

    @Autowired
    AdminService service;

    @PostMapping
    public AdminResponse addAdmin(@RequestBody AdminRequest adminRequest) {
        AdminResponse adminResponse = new AdminResponse();
        AdminDTO adminDTO = new AdminDTO();
        BeanUtils.copyProperties(adminRequest, adminDTO);
        AdminDTO savedAdminDTO = service.addAdmin(adminDTO);
        BeanUtils.copyProperties(savedAdminDTO, adminResponse);
        return adminResponse;
    }

    @GetMapping("/{id}")
    public AdminResponse getAdminById(@PathVariable long id) {
        AdminDTO adminDTO = service.getAdminById(id);
        AdminResponse adminResponse = new AdminResponse();
        BeanUtils.copyProperties(adminDTO, adminResponse);
        return adminResponse;
    }
   
    @GetMapping("/find")
    public AdminResponse findAdminByUsernameAndPassword(@RequestBody AdminRequest adminRequest) {
        String username = adminRequest.getUsername();
        String password = adminRequest.getPassword();
        
        AdminDTO adminDTO = service.findAdminByUsernameAndPassword(username, password);
        AdminResponse adminResponse = new AdminResponse();
        BeanUtils.copyProperties(adminDTO, adminResponse);
        return adminResponse;
    }
    @PostMapping("/login")
    public AdminResponse loginAdmin(@RequestBody AdminRequest adminRequest) {
        String username = adminRequest.getUsername();
        String password = adminRequest.getPassword();
        
        AdminDTO adminDTO = service.findAdminByUsernameAndPassword(username, password);
        AdminResponse adminResponse = new AdminResponse();
        BeanUtils.copyProperties(adminDTO, adminResponse);
        return adminResponse;
    }
    

    
    
}
