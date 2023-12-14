package rw.mis.employee.employeemanagamentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Task;
import rw.mis.employee.employeemanagamentsystem.service.EmployeeService;
import rw.mis.employee.employeemanagamentsystem.service.TaskService;

import java.util.List;

@Controller
public class TaskController {
    private TaskService taskService;
    private EmployeeService employeeService;
    @Autowired
    public TaskController(TaskService taskService, EmployeeService employeeService) {
        this.taskService = taskService;
        this.employeeService = employeeService;
    }
    @GetMapping("/adminTask")
    public String allTasks(Model model) {
        Task task=new Task();
        List<Task> tasks=taskService.allTask();
        model.addAttribute("task",task);
        model.addAttribute("tasks",tasks);

        Employee employee=new Employee();
        List<Employee> employees=employeeService.getEmployees();
        model.addAttribute("employees",employees);
        model.addAttribute("employee",employee);

        return "adminTask";
    }
    @PostMapping("/newAdminTask")
    public String newTask(Task task,Model model) {
        Task task1=taskService.newTask(task);
        if(task1==null){
            model.addAttribute("FailureMessage","Fail to create Payment");
        }else{
            model.addAttribute("SuccessMessage","Payment created successfully");
        }

        return "redirect:/adminTask";
    }
}
