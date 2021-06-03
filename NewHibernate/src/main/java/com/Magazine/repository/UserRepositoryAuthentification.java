package com.Magazine.repository;


import com.Magazine.entity.UserAuthentification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryAuthentification extends JpaRepository<UserAuthentification, Long> {
    UserAuthentification findByUsername(String username);
}
