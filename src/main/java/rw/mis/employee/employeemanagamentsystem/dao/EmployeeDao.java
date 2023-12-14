package rw.mis.employee.employeemanagamentsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.mis.employee.employeemanagamentsystem.model.Admin;
import rw.mis.employee.employeemanagamentsystem.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee,String> {
    @Query("from Employee where email= :email")
    Employee findByEmail(String email);
    @Query("from Employee where phone= :phone")
    Employee findByPhone(String phone);

    @Query("from Employee where email = :email and password = :password")
    Employee login(String email, String password);


}
