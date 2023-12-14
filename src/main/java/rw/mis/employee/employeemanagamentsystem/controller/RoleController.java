package rw.mis.employee.employeemanagamentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Department;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Role;
import rw.mis.employee.employeemanagamentsystem.service.RoleService;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
@GetMapping("/adminRole")
    public String allRoles(Model model){
        Role role= new Role();
        List<Role> roles = roleService.roles();
        model.addAttribute("roles", roles);
        model.addAttribute("role", role);
        return "adminRole";

    }
    @PostMapping("/adminNewRole")
    public String newRole(Role role,Model model) {
    Role role1= roleService.newRole(role);
    if(role1==null){
        model.addAttribute("FailureMessage","Fail to Create Role");
    }else{
        model.addAttribute("SuccessMessage","Role created successfully");
    }

    return "redirect:/adminRole";
    }

    @GetMapping("/findEmployeePerRole")
    public String getEmployeesByBranch(@RequestParam Integer roleId, Model model) {
        List<Employee> employees = roleService.getEmployeesByRoleId(roleId);
        Role r=roleService.findById(roleId);
        model.addAttribute("selected","List of employee by role of "+ r.getRoleTitle() );

        Employee employee= new Employee();
        model.addAttribute("employees", employees);
        model.addAttribute("employee",employee);

        Role role= new Role();
        List<Role> roles = roleService.roles();
        model.addAttribute("roles", roles);
        model.addAttribute("role", role);

        return "employeeRole";
    }

    @GetMapping("/deleteRole/{roleId}")
    public String deleteBranch(@PathVariable Integer roleId, Model model) {
        roleService.deleteRole(roleId);
        return "redirect:/adminRole";
    }


    @GetMapping("/editRole/{roleId}")
    public String editRolePage(@PathVariable Integer roleId, Model model) {
        // Retrieve role information by roleId and add it to the model
        Role role = roleService.findById(roleId);
        model.addAttribute("role", role);

        return "editRole"; // Assuming your Thymeleaf template is named "editRole.html"
    }


    @PostMapping("/adminUpdateRole")
    public String updateRole(@ModelAttribute("role") Role role) {
        roleService.updateRole(role);
        return "redirect:/adminRole";
    }

}
