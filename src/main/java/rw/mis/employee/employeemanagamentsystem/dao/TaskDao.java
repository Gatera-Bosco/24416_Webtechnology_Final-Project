package rw.mis.employee.employeemanagamentsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.mis.employee.employeemanagamentsystem.model.Task;

import java.util.List;

public interface TaskDao extends JpaRepository<Task,Integer> {
    @Query("from Task where employee.employeeId =:employeeId")
    List<Task> findByEmployeeEmployeeId(String employeeId);
}
