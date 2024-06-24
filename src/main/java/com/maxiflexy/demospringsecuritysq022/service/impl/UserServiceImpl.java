package com.maxiflexy.demospringsecuritysq022.service.impl;

import com.maxiflexy.demospringsecuritysq022.dto.AuthResponseDto;
import com.maxiflexy.demospringsecuritysq022.dto.RegistrationDto;
import com.maxiflexy.demospringsecuritysq022.dto.RegistrationInfo;
import com.maxiflexy.demospringsecuritysq022.entity.UserEntity;
import com.maxiflexy.demospringsecuritysq022.enums.Role;
import com.maxiflexy.demospringsecuritysq022.repository.UserRepository;
import com.maxiflexy.demospringsecuritysq022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public AuthResponseDto registerUser(RegistrationDto registrationDto) {
        UserEntity user = UserEntity.builder()
                                .firstName(registrationDto.getFirstName())
                                .lastName(registrationDto.getLastName())
                                .email(registrationDto.getEmail())
                                .password(registrationDto.getPassword())
                                .role(Role.USER)
                                .build();

        userRepository.save(user);

        return AuthResponseDto.builder()
                .responseCode("001")
                .responseMessage("Account created successfully")
                .registrationInfo(RegistrationInfo.builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .build())
                .build();
    }
}
