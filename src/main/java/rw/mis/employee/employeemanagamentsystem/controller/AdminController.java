package rw.mis.employee.employeemanagamentsystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.mis.employee.employeemanagamentsystem.model.Admin;
import rw.mis.employee.employeemanagamentsystem.service.AdminService;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/newAdmin")
    public ResponseEntity<Admin> newAdmin(@RequestBody Admin admin) {
        Admin newAdmin= adminService.newAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);

    }
    @GetMapping("/allAdmin")
    public ResponseEntity<List<Admin>> getAll(){
        List<Admin> admins= adminService.adminList();
        return new ResponseEntity<>(admins, HttpStatus.OK);

    }


}
