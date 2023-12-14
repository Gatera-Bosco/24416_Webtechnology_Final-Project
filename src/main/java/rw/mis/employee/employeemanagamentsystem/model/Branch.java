package rw.mis.employee.employeemanagamentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer branchId;
    private String branchName;
    private String address;
    @OneToMany(mappedBy = "branch")
    private List<Employee> employeeList;

}
