package rw.mis.employee.employeemanagamentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer payrollId;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    private String payPeriod;
    private LocalDate payDate;
    private double amount;

    @PrePersist
    public void prePersist() {
        this.payDate = LocalDate.now();
    }
}
