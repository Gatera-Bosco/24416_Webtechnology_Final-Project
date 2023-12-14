package rw.mis.employee.employeemanagamentsystem.service;

import org.springframework.stereotype.Service;
import rw.mis.employee.employeemanagamentsystem.model.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin newAdmin(Admin admin);
    List<Admin> adminList();
    Admin login(String email,String password);

}
