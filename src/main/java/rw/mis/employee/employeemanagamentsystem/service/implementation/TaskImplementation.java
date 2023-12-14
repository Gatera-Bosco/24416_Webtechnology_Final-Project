package rw.mis.employee.employeemanagamentsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.mis.employee.employeemanagamentsystem.dao.TaskDao;
import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Task;
import rw.mis.employee.employeemanagamentsystem.service.EmailService;
import rw.mis.employee.employeemanagamentsystem.service.TaskService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TaskImplementation implements TaskService {
    @Autowired
    private TaskDao dao;
    @Autowired
    private EmailService emailService;
    @Override
    public Task newTask(Task task) {
        Task createdTask = dao.save(task);
        Employee assignedEmployee= task.getEmployee();
        if(createdTask != null) {
            emailService.sendEmail(assignedEmployee,createdTask);
        }
        return createdTask ;
    }

    @Override
    public void deleteTask(Integer taskId) {
        if(dao.existsById(taskId)){
            dao.deleteById(taskId);
        }
    }

    @Override
    public Task updateTask(Integer taskId,Task task) {
        if(dao.existsById(taskId)){
           return dao.save(task);
        }else {
            return null;
        }

    }

    @Override
    public List<Task> allTask() {
        return dao.findAll();
    }

    @Override
    public List<Task> getTasksByEmployeeId(String employeeId) {
        return dao.findByEmployeeEmployeeId(employeeId);
    }


}
