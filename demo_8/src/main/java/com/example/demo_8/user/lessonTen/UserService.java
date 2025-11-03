package com.example.demo_8.user.lessonTen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserDTO userDTO) {
        UserTest user = new UserTest(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmail(),
                "ROLE_USER"
        );
        userRepository.save(user);
    }

    public UserTest findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
