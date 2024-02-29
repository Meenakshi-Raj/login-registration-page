package com.project.login.page.service;

import com.project.login.page.entity.User;
import com.project.login.page.entity.UserDTO;

import java.util.List;

public interface LoginPageService {
    void save(UserDTO userDTO);
    User findUserbyEmail(String email);
    List<UserDTO> findAllUsers();
}
