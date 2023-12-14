package rw.mis.employee.employeemanagamentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.service.BranchService;

import java.util.List;

@Controller
public class BranchController {
    @Autowired
    private BranchService branchService;
    @GetMapping("/adminBranch")
    public String allBranch(Model model) {
        Branch branch= new Branch();
        List<Branch> branches = branchService.branches();
        model.addAttribute("branch", branch);
        model.addAttribute("branches", branches);
        return "adminBlanch";
    }
    @PostMapping("/adminNewBranch")
    public String newBranch(Branch branch,Model model) {
        Branch branch1=branchService.newBranch(branch);
        if(branch1 != null) {
            model.addAttribute("SuccessMessage", "Branch Successfully created ");
        }else {
            model.addAttribute("FailureMessage", "Branch not created");
        }
        return "redirect:/adminBranch";
    }

    @GetMapping("/findEmployeePerBranch")
    public String getEmployeesByBranch(@RequestParam Integer branchId, Model model) {
        List<Employee> employees = branchService.getEmployeesByBranchId(branchId);
        Branch b=branchService.getBranchById(branchId);
        model.addAttribute("selected"," List of Employee for "+b.getBranchName()+" branch");
       Employee employee= new Employee();
        model.addAttribute("employees", employees);
        model.addAttribute("employee",employee);

        List<Branch> branches = branchService.branches();
        Branch branch= new Branch();
        model.addAttribute("branches", branches);
        model.addAttribute("branch", branch);// Add model attributes if

        return "employeeBranch";
    }


    @GetMapping("/deleteBranch/{branchId}")
    public String deleteBranch(@PathVariable Integer branchId, Model model) {
        branchService.deleteBranch(branchId);
        return "redirect:/adminBranch";
    }

    @GetMapping("/editBranch/{branchId}")
    public String editBranchPage(@PathVariable Integer branchId, Model model) {
        // Retrieve branch information by branchId and add it to the model
        Branch branch = branchService.getBranchById(branchId);
        model.addAttribute("branch", branch);

        return "editBranch";
    }

    @PostMapping("/adminUpdateBranch")
    public String updateBranch(@ModelAttribute("branch") Branch branch) {
       branchService.updateBranch(branch);
        return "redirect:/adminBranch";
    }
}
