package com.ieumsae.project.member.login.config;

import com.ieumsae.project.member.login.model.LoginModel;
import com.ieumsae.project.member.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final LoginRepository loginRepository;

    @Autowired
    public CustomUserDetailsService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginModel loginModel = loginRepository.findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return User.builder()
                .username(loginModel.getUserId())
                .password(loginModel.getUserPwd())
                .roles("USER") // 사용자 역할을 지정하세요
                .build();
    }
}
