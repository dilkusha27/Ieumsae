package com.ieumsae.project.member.login.service;

import com.ieumsae.project.member.login.model.LoginModel;
import com.ieumsae.project.member.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    //멤버변수
    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean login(String userId, String userPwd) {
        Optional<LoginModel> idCheck = loginRepository.findByUserId(userId);
        if (idCheck.isPresent()) {
            LoginModel loginId = idCheck.get();
            if (passwordEncoder.matches(userPwd, loginId.getUserPwd())) {
                return true; //로그인 성공
            }
        }
        return false; // 로그인 실패
    }

    @Override // 이메일로 아이디 찾기
    public String findIdByEmail(String userEmail) {
        Optional<LoginModel> user = loginRepository.findByUserEmail(userEmail);
        if (user.isPresent()) {
            return user.get().getUserId();
        }
        return null; // 해당 이메일의 매칭되는 아이디가 없음
    }

    @Override // 이메일로 비밀번호 찾기
    public String findPwdByEmail(String userEmail) {
        Optional<LoginModel> user = loginRepository.findByUserEmail(userEmail);
        if (user.isPresent()) {
            return user.get().getUserPwd();
        }
        return null;
    }
}
