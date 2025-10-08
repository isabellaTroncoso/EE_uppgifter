package com.bella.demo_2.student;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//@Primary
@Profile("prod")
@Service
public class JpaStudentService implements StudentService
{
    @Override
    public String getStudentInfo(Long id) {
        return "Hello from JPA (id = " + id + ")";
    }
}