package rw.mis.employee.employeemanagamentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Payroll;
import rw.mis.employee.employeemanagamentsystem.service.EmployeeService;
import rw.mis.employee.employeemanagamentsystem.service.PayrollService;

import java.util.List;

@Controller
public class PayrollController {
    private PayrollService payrollService;
    private EmployeeService employeeService;
    @Autowired
    public PayrollController(PayrollService payrollService, EmployeeService employeeService) {
        this.payrollService = payrollService;
        this.employeeService = employeeService;
    }
    @GetMapping("/adminPayroll")
    private String getPayroll(Model model){
        Payroll payroll = new Payroll();
        List<Payroll> payrolls =payrollService.allPayrolls();
        model.addAttribute("payroll",payroll);
        model.addAttribute("payrolls",payrolls);

        Employee employee= new Employee();
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("employee",employee);

        return "adminPayment";
    }
    @PostMapping("/adminNewPayment")
    private String newPayment(Payroll payroll, Model model) {
        Payroll payroll1= payrollService.newPayroll(payroll);
        if(payroll1==null){
            model.addAttribute("FailureMessage","Fail to create Payment");
        }else{
            model.addAttribute("SuccessMessage","Payment created successfully");
        }
        return "redirect:/adminPayroll";
    }
}
