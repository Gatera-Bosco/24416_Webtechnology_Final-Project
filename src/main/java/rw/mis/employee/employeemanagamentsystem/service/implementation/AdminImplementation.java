package rw.mis.employee.employeemanagamentsystem.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import rw.mis.employee.employeemanagamentsystem.dao.AdminDao;
import rw.mis.employee.employeemanagamentsystem.model.Admin;
import rw.mis.employee.employeemanagamentsystem.service.AdminService;

import java.util.List;
import java.util.Optional;

@Service
public class AdminImplementation implements AdminService {
    @Autowired
    private AdminDao dao;
    @Override
    public Admin newAdmin(Admin admin) {
        return dao.save(admin);
    }

    @Override
    public List<Admin> adminList() {
        return dao.findAll();
    }

    @Override
    public Admin login(String email, String password) {
        return dao.login(email, password);
    }


}

