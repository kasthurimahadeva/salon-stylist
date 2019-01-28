package com.kasthuri.authservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    private UserRepository userRepository;

    @PostMapping("auth/register")
    public AppUser register(@RequestBody UserDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        log.debug("new registration request: {}", userDto);
        AppUser appUser = new AppUser();
        appUser.setUsername(userDto.getUsername());
        appUser.setPassword(encoder.encode(userDto.getPassword()));
        appUser.setRole(userDto.getRole().toLowerCase());
        return userRepository.save(appUser);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
