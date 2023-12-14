package rw.mis.employee.employeemanagamentsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Employee {
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    @ManyToOne
    @JoinColumn(name = "branchId")
    private Branch branch;
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    private LocalDate hireDate;
    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;
    @PrePersist
    public void prePersist() {
        this.hireDate = LocalDate.now();
    }
    @OneToMany(mappedBy = "employee")
    private List<Task> tasks;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;


}
