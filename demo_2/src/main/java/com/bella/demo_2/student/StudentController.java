package com.bella.demo_2.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentService studentService; // interface
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/student")
    public String getStudent() {
        return studentService.getStudentInfo(1L);
    }
}
/* Vilken service kördes, och varför just den?
* Svar: JPA Student Id 1 kom först! Den hade annotationen @Primary som
* betyder att den går först men endast om flera finns”.
*
* följde uppgift #7 och nu fick jag detta i webläsaren:
* Hello from InMemory (id = 1). --> Application.properties: Bestämmer vilken miljö (service) som körs just nu*/
