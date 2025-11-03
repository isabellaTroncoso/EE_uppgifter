package com.example.demo_8.user.lessonTen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTest, Long> {
    UserTest findByUsername(String username);
}

