package rw.mis.employee.employeemanagamentsystem.service;

import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Employee;

import java.util.List;
import java.util.Map;

public interface BranchService {
    Branch newBranch(Branch branch);
    void deleteBranch(Integer branchId);
    Branch updateBranch(Branch branch);
    List<Branch> branches();
    List<Employee> getEmployeesByBranchId(Integer branchId);
    Branch getBranchById(Integer branchId);

}
