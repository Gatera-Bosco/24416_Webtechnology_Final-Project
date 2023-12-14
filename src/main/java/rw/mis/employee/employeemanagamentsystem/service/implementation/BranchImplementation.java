package rw.mis.employee.employeemanagamentsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.mis.employee.employeemanagamentsystem.dao.BranchDao;
import rw.mis.employee.employeemanagamentsystem.model.Branch;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.service.BranchService;

import java.util.Collections;
import java.util.List;

import java.util.Optional;

@Service
public class BranchImplementation implements BranchService {
    @Autowired
    private BranchDao dao;
    @Override
    public Branch newBranch(Branch branch) {
        return dao.save(branch);
    }

    @Override
    public void deleteBranch(Integer branchId) {
        if(dao.existsById(branchId)){
            dao.deleteById(branchId);
        }

    }


    @Override
    public Branch updateBranch(Branch branch) {

            return dao.save(branch);


    }

    @Override
    public List<Branch> branches() {
        return dao.findAll();
    }

    @Override
    public List<Employee> getEmployeesByBranchId(Integer branchId) {
        Optional<Branch> optionalBranch = dao.findById(branchId);
        return optionalBranch.map(Branch::getEmployeeList).orElse(Collections.emptyList());
    }

    @Override
    public Branch getBranchById(Integer branchId) {
        return dao.findById(branchId).get();
    }


}
