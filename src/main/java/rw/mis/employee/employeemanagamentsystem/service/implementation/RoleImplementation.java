package rw.mis.employee.employeemanagamentsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.mis.employee.employeemanagamentsystem.dao.RoleDao;
import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Role;
import rw.mis.employee.employeemanagamentsystem.service.RoleService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RoleImplementation implements RoleService {
    @Autowired
    private RoleDao dao;
    @Override
    public Role newRole(Role role) {
        return dao.save(role);
    }

    @Override
    public void deleteRole(Integer roleId) {
        if(dao.existsById(roleId)){
            dao.deleteById(roleId);
        }
    }

    @Override
    public Role updateRole(Role role) {

          return   dao.save(role);


    }

    @Override
    public List<Role> roles() {
        return dao.findAll();
    }

    @Override
    public List<Employee> getEmployeesByRoleId(Integer roleId) {
        Optional<Role> optionalRole = dao.findById(roleId);
        return optionalRole.map(Role::getEmployeeList).orElse(Collections.emptyList());
    }

    @Override
    public Role findById(Integer roleId) {
        return dao.findById(roleId).get();
    }
}
