package rw.mis.employee.employeemanagamentsystem.service;

import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Task;

public interface EmailService {
    void sendEmail(Employee employee, Task task);
}
