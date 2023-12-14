package rw.mis.employee.employeemanagamentsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.mis.employee.employeemanagamentsystem.model.Role;

public interface RoleDao extends JpaRepository<Role,Integer> {
}
