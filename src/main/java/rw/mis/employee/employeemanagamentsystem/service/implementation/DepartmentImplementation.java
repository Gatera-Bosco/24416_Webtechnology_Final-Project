package rw.mis.employee.employeemanagamentsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.mis.employee.employeemanagamentsystem.dao.DepartmentDao;
import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Department;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.service.DepartmentService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentImplementation implements DepartmentService {
    @Autowired
    private DepartmentDao dao;
    @Override
    public Department newDepartment(Department department) {
        return dao.save(department);
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        if(dao.existsById(departmentId)){
           dao.deleteById(departmentId);
        }
    }

    @Override
    public Department updateDepartment(Department department) {

            return dao.save(department);

    }

    @Override
    public List<Department> getDepartments() {
        return dao.findAll();
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(Integer departmentId) {
        Optional<Department> optionalDepartment = dao.findById(departmentId);
        return optionalDepartment.map(Department::getEmployeeList).orElse(Collections.emptyList());
    }

    @Override
    public Department findById(Integer departmentId) {
        return dao.findById(departmentId).get();
    }
}
