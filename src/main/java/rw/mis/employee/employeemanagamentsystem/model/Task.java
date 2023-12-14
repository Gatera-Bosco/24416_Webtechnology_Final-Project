package rw.mis.employee.employeemanagamentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer taskId;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    private String title;
    private String description;
    private LocalDate dueDate;


}
