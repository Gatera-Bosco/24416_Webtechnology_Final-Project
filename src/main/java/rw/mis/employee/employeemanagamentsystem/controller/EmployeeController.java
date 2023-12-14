package rw.mis.employee.employeemanagamentsystem.controller;

import jakarta.servlet.http.HttpSession;
import org.hibernate.query.sqm.mutation.internal.temptable.LocalTemporaryTableInsertStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import rw.mis.employee.employeemanagamentsystem.model.*;
import rw.mis.employee.employeemanagamentsystem.service.BranchService;
import rw.mis.employee.employeemanagamentsystem.service.DepartmentService;
import rw.mis.employee.employeemanagamentsystem.service.EmployeeService;
import rw.mis.employee.employeemanagamentsystem.service.RoleService;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    private BranchService branchService;
    private RoleService roleService;
    private DepartmentService departmentService;
    @Autowired
    public EmployeeController(EmployeeService employeeService, BranchService branchService, RoleService roleService, DepartmentService departmentService) {
        this.employeeService = employeeService;
        this.branchService = branchService;
        this.roleService = roleService;
        this.departmentService = departmentService;
    }

    @GetMapping("/adminEmployee")
    public String getEmployee(Model model){
        Employee employee= new Employee();
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("employee",employee);

        Role role = new Role();
        List<Role> roles = roleService.roles();
        model.addAttribute("roles", roles);
        model.addAttribute("role", role);

        Branch branch= new Branch();
        List<Branch> branches = branchService.branches();
        model.addAttribute("branches", branches);
        model.addAttribute("branch", branch);

        Department department = new Department();
        List<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("department", department);

        return "adminEmployee";
    }

    @PostMapping("/adminNewEmployee")
    public String newEmployee(Employee employee, @RequestParam("photoFile") MultipartFile photoFile, Model model) {
        Employee employee1=employeeService.newEmployee(employee,photoFile);
        if(employee1==null){
            model.addAttribute(
                    "FailureMessage","Failed to create employee");
        }else{
            model.addAttribute("SuccessMessage","Employee created successfully ");
        }
        return "redirect:/adminEmployee";
    }


    @GetMapping("/findTaskPerEmployee")
    public String getTaskOfEmployee(@RequestParam String employeeId,Model model){
        List<Task> tasks = employeeService.getTaskOfEmployee(employeeId);
        Employee emp=employeeService.getEmployeeById(employeeId);
        model.addAttribute("selected","List of Tasks by Employee "+emp.getLastName()+" "+emp.getFirstName());
        Task task= new Task();
        Employee employee= new Employee();
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("employee",employee);
        model.addAttribute("task",task);
        model.addAttribute("tasks",tasks);


        return "employeeTask";
    }


    @PostMapping("/employeeLogin")
    public String login(@RequestParam String userName, @RequestParam String password, Model model, HttpSession session){
        Employee employee=employeeService.login(userName,password);
        if(employee != null){
            session.setAttribute("authenticatedEmployee", employee);
            return "redirect:/employee";
        }else{
            model.addAttribute("errorMessage", "Incorrect username or password");
            return "index";
        }
    }


    @GetMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId, Model model) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/adminEmployee";
    }

    @GetMapping("/updateEmployee/{employeeId}")
    public String updateEmployeePage(@PathVariable String employeeId, Model model) {
        // Retrieve employee information by employeeId and add it to the model
        Employee employee = employeeService.getEmployeeById(employeeId);

        model.addAttribute("employee", employee);
        // Add other necessary model attributes like departments, roles, branches, etc.

        return "editEmployee";
    }

    @PostMapping("/adminUpdateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.updateEmployee(employee);
        return "redirect:/adminEmployee";
    }
}
