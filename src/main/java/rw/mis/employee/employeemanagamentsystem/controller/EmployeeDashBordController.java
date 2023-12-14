package rw.mis.employee.employeemanagamentsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Payroll;
import rw.mis.employee.employeemanagamentsystem.model.Task;
import rw.mis.employee.employeemanagamentsystem.service.EmployeeService;
import rw.mis.employee.employeemanagamentsystem.service.PayrollService;
import rw.mis.employee.employeemanagamentsystem.service.TaskService;

import java.util.List;

@Controller
public class EmployeeDashBordController {
    private EmployeeService employeeService;
    private TaskService taskService;
    private PayrollService payrollService;
@Autowired
    public EmployeeDashBordController(EmployeeService employeeService, TaskService taskService, PayrollService payrollService) {
        this.employeeService = employeeService;
        this.taskService = taskService;
        this.payrollService = payrollService;
    }

    @GetMapping("/employee")
    public String displayEmployee(HttpSession session, Model model) {
        Employee authenticatedEmployee = (Employee) session.getAttribute("authenticatedEmployee");
        if(authenticatedEmployee != null) {
            model.addAttribute("authenticatedEmployee", authenticatedEmployee);
            return "employee";
        }
         else {
             return "index";
        }
    }

    @GetMapping("/employeePayment")
    public String gettAllPAymentOfEmployee(HttpSession session,Model model){

        Employee authenticatedEmployee = (Employee) session.getAttribute("authenticatedEmployee");
        if(authenticatedEmployee != null) {
            model.addAttribute("authenticatedEmployee", authenticatedEmployee);
            Payroll payroll= new Payroll();
            List<Payroll> payrolls= payrollService.getPayrollsByEmployeeId(authenticatedEmployee.getEmployeeId());
            if(payrolls != null){
                model.addAttribute("payrolls", payrolls);
                model.addAttribute("payroll",payroll);
            }
            return "employeeDashPayment";
        }
        else {
            return "index";
        }
    }

    @GetMapping("/employeeProfile")
    public String employeeProfile(HttpSession session,Model model){
        Employee authenticatedEmployee = (Employee) session.getAttribute("authenticatedEmployee");
        if(authenticatedEmployee != null) {
            model.addAttribute("authenticatedEmployee", authenticatedEmployee);
            return "employeeDashProfile";
        }
        else {
            return "index";
        }


    }
    @GetMapping("/employeeTask")
    public String getAllEmployeeTasks(HttpSession session,Model model){
        Employee authenticatedEmployee = (Employee) session.getAttribute("authenticatedEmployee");
        if(authenticatedEmployee != null) {
            model.addAttribute("authenticatedEmployee", authenticatedEmployee);
            Task task= new Task();
            List<Task> tasks=taskService.getTasksByEmployeeId(authenticatedEmployee.getEmployeeId());
            if(tasks != null)
            {
                model.addAttribute("tasks", tasks);
                model.addAttribute("task", task);
            }

            return "employeeDashTask";
        }
        else {
            return "index";
        }
    }


}
