package com.project.login.page.service;

import com.project.login.page.entity.Role;
import com.project.login.page.entity.User;
import com.project.login.page.entity.UserDTO;
import com.project.login.page.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoginPageServiceImpl implements LoginPageService{
    @Autowired
    UserRepository userRepository;
    public LoginPageServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserDTO userDTO) {
         userRepository.save(new User(userDTO.getFirstname(), userDTO.getLastname(),
                userDTO.getEmail(), userDTO.getPassword(), List.of(new Role("User"))));
    }

    @Override
    public User findUserbyEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((this::mapToUserDTO)).collect(Collectors.toList());
    }

    private UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstname(user.getFirstName());
        userDTO.setLastname(userDTO.getLastname());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
