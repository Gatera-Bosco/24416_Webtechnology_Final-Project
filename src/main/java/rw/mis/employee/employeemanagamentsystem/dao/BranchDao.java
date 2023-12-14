package rw.mis.employee.employeemanagamentsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.mis.employee.employeemanagamentsystem.model.Branch;

public interface BranchDao extends JpaRepository<Branch,Integer> {
}
