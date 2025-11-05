package com.example.demo_6.mapper;

import com.example.demo_6.dto.CustomUserCreationDTO;
import com.example.demo_6.dto.CustomUserResponseDTO;
import com.example.demo_6.user.custom.CustomUser;
import org.springframework.stereotype.Component;

/** CustomUserMapper:
 *   Converts CustomUser to Entity.
 *   Converts Entity to UsernameDTO
 * */

@Component
public class CustomUserMapper {

    public CustomUser toEntity(CustomUserCreationDTO customUserCreationDTO) {

        return new CustomUser(
                customUserCreationDTO.username(),
                customUserCreationDTO.password(),
                customUserCreationDTO.isAccountNonExpired(),
                customUserCreationDTO.isAccountNonLocked(),
                customUserCreationDTO.isCredentialsNonExpired(),
                customUserCreationDTO.isEnabled(),
                customUserCreationDTO.roles()
        );
    }

    public CustomUserResponseDTO toUsernameDTO(CustomUser customUser) {

        return new CustomUserResponseDTO(customUser.getUsername());
    }

}
