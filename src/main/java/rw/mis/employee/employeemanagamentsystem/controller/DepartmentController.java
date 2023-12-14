package rw.mis.employee.employeemanagamentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Department;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.service.DepartmentService;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/adminDepartment")
    private String allDepartments(Model model) {
        Department department= new Department();
        List<Department> departments= departmentService.getDepartments();
        model.addAttribute("department",department);
        model.addAttribute("departments",departments);

        return "adminDepartment";

    }
    @PostMapping("/adminDepartment")
    public String newDepartment(Department department,Model model) {
        Department department1= departmentService.newDepartment(department);
        if(department1==null){
            model.addAttribute("FailureMessage", "Fail to create department");

        }else {
            model.addAttribute("SuccessMessage", "Department created successfully");
        }
        return "redirect:/adminDepartment";
    }

    @GetMapping("/findEmployeePerDepartment")
    public String getEmployeesByBranch(@RequestParam Integer departmentId, Model model) {
        List<Employee> employees = departmentService.getEmployeesByDepartmentId(departmentId);
        Department d=departmentService.findById(departmentId);
        model.addAttribute("selected","List of employees in the department of "+d.getDepartmentName());

        Employee employee= new Employee();
        model.addAttribute("employees", employees);
        model.addAttribute("employee",employee);

        Department department= new Department();
        List<Department> departments= departmentService.getDepartments();
        model.addAttribute("department",department);
        model.addAttribute("departments",departments);

        return "employeeDepartment";
    }

    @GetMapping("/deleteDepartment/{departmentId}")
    public String deleteDepartment(@PathVariable Integer departmentId, Model model) {
        departmentService.deleteDepartment(departmentId);
        return "redirect:/adminDepartment";
    }

    @GetMapping("/editDepartment/{departmentId}")
    public String editDepartmentPage(@PathVariable Integer departmentId, Model model) {
        // Retrieve department information by departmentId and add it to the model
        Department department = departmentService.findById(departmentId);
        model.addAttribute("department", department);

        return "editDepartment";
    }

    @PostMapping("/adminUpdateDepartment")
    public String updateDepartment(@ModelAttribute("department") Department department) {
        departmentService.updateDepartment(department);
        return "redirect:/adminDepartment";
    }
}
