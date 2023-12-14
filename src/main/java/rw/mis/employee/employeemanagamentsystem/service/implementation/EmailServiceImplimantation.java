package rw.mis.employee.employeemanagamentsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import rw.mis.employee.employeemanagamentsystem.model.Employee;
import rw.mis.employee.employeemanagamentsystem.model.Task;
import rw.mis.employee.employeemanagamentsystem.service.EmailService;
import rw.mis.employee.employeemanagamentsystem.service.TaskService;
@Service
public class EmailServiceImplimantation implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(Employee employee, Task task) {
        SimpleMailMessage message= new SimpleMailMessage();
        message.setTo(employee.getEmail());
        message.setSubject("New Task Notification");
        message.setText("hello "+"  "+employee.getFirstName()+"   "+employee.getLastName()+ "  "+task.getTitle()+" "+task.getDescription());
        javaMailSender.send(message);


    }
}
