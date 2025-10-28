package com.example.demo_6;

import com.example.demo_6.user.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo6Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo6Application.class, args);

		System.out.println(UserRole.GUEST.getSimpleGrantedAuthorities());
		System.out.println(UserRole.USER.getSimpleGrantedAuthorities());
		System.out.println(UserRole.ADMIN.getSimpleGrantedAuthorities());
	}

}
