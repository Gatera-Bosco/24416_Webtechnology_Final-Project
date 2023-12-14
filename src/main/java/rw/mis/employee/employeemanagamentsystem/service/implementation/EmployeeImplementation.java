package rw.mis.employee.employeemanagamentsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rw.mis.employee.employeemanagamentsystem.dao.EmployeeDao;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Task;
import rw.mis.employee.employeemanagamentsystem.service.EmployeeService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImplementation implements EmployeeService {
    @Autowired
    private EmployeeDao dao;


    @Override
    public Employee newEmployee(Employee employee, MultipartFile photoFile) {
//        if(photoFile != null && !photoFile.isEmpty()) {
//            try {
//                employee.setImage(photoFile.getBytes());
//            }catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//        }
        return dao.save(employee);
    }

    @Override
    public void deleteEmployee(String employeeId) {
        if(dao.existsById(employeeId)){
            dao.deleteById(employeeId);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if(dao.existsById(employee.getEmployeeId())){
           return dao.save(employee);
        }else {
            return  null;
        }
    }

    @Override
    public List<Employee> getEmployees() {
        return dao.findAll();
    }

    @Override
    public List<Task> getTaskOfEmployee(String employeeId) {
        Optional<Employee> optionalEmployee = dao.findById(employeeId);
        return optionalEmployee.map(Employee::getTasks).orElse(Collections.emptyList());
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return dao.findById(employeeId).orElse(null);
    }

    @Override
    public Employee findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public Employee findByPhone(String phone) {
        return dao.findByPhone(phone);
    }

    @Override
    public Employee login(String email, String password) {
        return dao.login(email, password);
    }
}
