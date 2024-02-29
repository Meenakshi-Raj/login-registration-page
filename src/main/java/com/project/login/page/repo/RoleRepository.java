package com.project.login.page.repo;

import com.project.login.page.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long>{
    //Role findByName(String roleName);
}

