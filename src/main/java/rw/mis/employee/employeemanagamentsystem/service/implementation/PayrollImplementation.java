package rw.mis.employee.employeemanagamentsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.mis.employee.employeemanagamentsystem.dao.PayrollDao;
import rw.mis.employee.employeemanagamentsystem.model.Payroll;
import rw.mis.employee.employeemanagamentsystem.service.PayrollService;

import java.util.List;
@Service
public class PayrollImplementation implements PayrollService {
    @Autowired
    private PayrollDao dao;
    @Override
    public Payroll newPayroll(Payroll payroll) {
        return dao.save(payroll);
    }

    @Override
    public Payroll deletePayroll(Payroll payroll) {
        return null;
    }

    @Override
    public Payroll updatePayroll(Payroll payment) {
        return null;
    }

    @Override
    public List<Payroll> allPayrolls() {
        return dao.findAll();
    }

    @Override
    public List<Payroll> getPayrollsByEmployeeId(String employeeId) {
        return dao.findByEmployee_EmployeeId(employeeId);
    }


}
