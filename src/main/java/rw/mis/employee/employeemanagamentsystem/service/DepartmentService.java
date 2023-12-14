package rw.mis.employee.employeemanagamentsystem.service;

import rw.mis.employee.employeemanagamentsystem.model.Department;
import rw.mis.employee.employeemanagamentsystem.model.Employee;

import java.util.List;

public interface DepartmentService {
    Department newDepartment(Department department);
    void deleteDepartment(Integer departmentId);
    Department updateDepartment(Department department);
    List<Department> getDepartments();
    List<Employee> getEmployeesByDepartmentId(Integer departmentId);


    Department findById(Integer departmentId);
}
