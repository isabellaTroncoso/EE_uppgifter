package com.example.demo_6;

import com.example.demo_6.user.authority.UserRole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;

@SpringBootApplication
public class Demo6Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo6Application.class, args);

		System.out.println(UserRole.GUEST.getUserAuthorities());
		System.out.println(UserRole.USER.getUserAuthorities());
		System.out.println(UserRole.ADMIN.getUserAuthorities());

	}

}
