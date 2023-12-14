package rw.mis.employee.employeemanagamentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rw.mis.employee.employeemanagamentsystem.model.Admin;
import rw.mis.employee.employeemanagamentsystem.service.AdminService;

import java.util.Optional;
@Controller
public class AdminLoginController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/loginAdmin")
    private String adminLogin(Model model){
        return "adminLogin";
    }
    @PostMapping("/adminLogin")
    public String login(@RequestParam String userName, @RequestParam String password, Model model){
        Admin admin=adminService.login(userName,password);
        if(admin != null){

            return "redirect:/adminDash";
        }else{
            model.addAttribute("errorMessage", "Incorrect username or password");
            return "adminLogin";
        }
    }
}
