package rw.mis.employee.employeemanagamentsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.mis.employee.employeemanagamentsystem.model.Department;

public interface DepartmentDao extends JpaRepository<Department,Integer> {
}
