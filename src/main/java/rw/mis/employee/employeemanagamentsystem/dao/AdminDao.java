package rw.mis.employee.employeemanagamentsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.mis.employee.employeemanagamentsystem.model.Admin;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin,Integer> {
    @Query("from Admin where email = :email and password = :password")
    Admin login(String email,String password);
}
