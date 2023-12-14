package rw.mis.employee.employeemanagamentsystem.service;

import rw.mis.employee.employeemanagamentsystem.model.Payroll;

import java.util.List;

public interface PayrollService {
    Payroll newPayroll(Payroll payroll);
    Payroll deletePayroll(Payroll payroll);
    Payroll updatePayroll(Payroll payment);
    List<Payroll> allPayrolls();
    List<Payroll> getPayrollsByEmployeeId(String employeeId);


}
