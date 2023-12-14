package rw.mis.employee.employeemanagamentsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.mis.employee.employeemanagamentsystem.model.Payroll;

import java.util.List;

public interface PayrollDao extends JpaRepository<Payroll,Integer> {
    @Query("from Payroll where employee.employeeId = :employeeId")
    List<Payroll> findByEmployee_EmployeeId(String employeeId);

}
