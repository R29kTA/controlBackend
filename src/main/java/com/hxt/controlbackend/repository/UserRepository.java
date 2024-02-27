package com.hxt.controlbackend.repository;

import com.hxt.controlbackend.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByUsername(String username);
    User getUserByUsernameOrPhone(String username,Long phone);
}
