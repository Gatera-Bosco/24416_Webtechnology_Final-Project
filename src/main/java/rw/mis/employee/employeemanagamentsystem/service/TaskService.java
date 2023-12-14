package rw.mis.employee.employeemanagamentsystem.service;

import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Task;

import java.util.List;

public interface TaskService {
    Task newTask(Task task);
    void deleteTask(Integer taskId);
    Task updateTask( Integer taskId,Task task);
    List<Task> allTask();
    List<Task> getTasksByEmployeeId(String employeeId);

}
