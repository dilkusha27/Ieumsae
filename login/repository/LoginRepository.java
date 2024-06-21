package com.ieumsae.project.member.login.repository;


import com.ieumsae.project.member.login.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Long> {
    public Optional<LoginModel> findByUserId(String userId);
    public Optional<LoginModel> findByUserEmail(String userEmail);
}
