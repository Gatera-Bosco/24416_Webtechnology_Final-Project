package rw.mis.employee.employeemanagamentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleTitle;
    @OneToMany(mappedBy = "role")
    private List<Employee> employeeList;
}
