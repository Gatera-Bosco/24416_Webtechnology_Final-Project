package rw.mis.employee.employeemanagamentsystem.service;

import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Role;

import java.util.List;

public interface RoleService {
    Role newRole(Role role);
    void deleteRole(Integer roleId);
    Role updateRole(Role role);
    List<Role> roles();
    List<Employee> getEmployeesByRoleId(Integer roleId);

    Role findById(Integer roleId);
}
