package rw.mis.employee.employeemanagamentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Department;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Role;
import rw.mis.employee.employeemanagamentsystem.service.BranchService;
import rw.mis.employee.employeemanagamentsystem.service.DepartmentService;
import rw.mis.employee.employeemanagamentsystem.service.EmployeeService;
import rw.mis.employee.employeemanagamentsystem.service.RoleService;

import java.util.List;

@Controller

public class PageController {
    @Autowired
    private BranchService branchService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private RoleService roleService;
    @GetMapping("/adminDash")
    public String displayDashboard(Model model) {
        // Add model attributes if needed
        return "adminDash"; // Return the dashboard view name
    }

    @GetMapping("/employeePerBranch")
    public String employeePerBranch(Model model) {
        List<Branch> branches = branchService.branches();
        Branch branch= new Branch();
        model.addAttribute("branches", branches);
        model.addAttribute("branch", branch);// Add model attributes if needed
        return "employeeBranch"; // Return the dashboard view name
    }

    @GetMapping("/employeeDepartment")
    public String employeePerDepartment(Model model) {
        Department department= new Department();
        List<Department> departments= departmentService.getDepartments();
        model.addAttribute("department",department);
        model.addAttribute("departments",departments);
        return "employeeDepartment"; // Return the dashboard view name
    }

    @GetMapping("/employeePertTask")
    public String employeePerTask(Model model) {
        Employee employee= new Employee();
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("employee",employee);
        return "employeeTask"; // Return the dashboard view name
    }

    @GetMapping("/EmployeePerRole")
    public String employeePerRole(Model model) {
        Role role= new Role();
        List<Role> roles = roleService.roles();
        model.addAttribute("roles", roles);
        model.addAttribute("role", role);
        return "employeeRole"; // Return the dashboard view name
    }

    @GetMapping("/editEmployee")
    public String editEmpoloyee(Model model){
        Employee employee= new Employee();
        model.addAttribute("employee", employee);

        return "editEmployee";

    }
//    @GetMapping("/editeBranch")
//    public String editBlanch(Model model){
//
//
//        return "editBranch";
//
//    }
}
