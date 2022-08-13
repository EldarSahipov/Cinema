package com.java.cinema.service;

import com.java.cinema.entity.User;
import com.java.cinema.entity.statuses.Role;
import com.java.cinema.forms.UserForm;
import com.java.cinema.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log
public class RegistrationService {

    private final UsersService usersService;

    private  final UsersRepository usersRepository;

    private final PasswordEncoder passwordEncoder;

//регистрация нового пользователя
    public void reg(UserForm userForm)  {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
            User user = User.builder()
                    .password(hashPassword)
                    .email(userForm.getEmail())
                    .phone(userForm.getPhone())
                    .role(Role.USER)
                    .build();

        usersRepository.save(user);
    }
}
