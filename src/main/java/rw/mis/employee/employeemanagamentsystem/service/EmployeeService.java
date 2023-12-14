package rw.mis.employee.employeemanagamentsystem.service;

import org.springframework.web.multipart.MultipartFile;
import rw.mis.employee.employeemanagamentsystem.model.Admin;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Task;

import java.util.List;

public interface EmployeeService {
    Employee newEmployee(Employee employee);
    void deleteEmployee(String employeeId);
    Employee updateEmployee(Employee employee);
    List<Employee> getEmployees();
    List<Task> getTaskOfEmployee(String employeeId);
    Employee getEmployeeById(String employeeId);
    Employee findByEmail(String email);

    Employee findByPhone(String phone);

    Employee login(String email, String password);
}
