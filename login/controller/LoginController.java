package com.ieumsae.project.member.login.controller;

import com.ieumsae.project.member.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String userId, @RequestParam String userPwd, Model model) {
        if (loginService.login(userId, userPwd)) {
            return "index"; // 로그인 성공 시 메인페이지로 이동
        } else {
            model.addAttribute("error", "로그인 정보가 일치하지 않습니다.");
            return "login"; // 로그인 실패 시 로그인 페이지로 다시 이동
        }
    }

    @GetMapping("/findId")
    public String findIdPage() {
        return "findId";
    }

    @PostMapping("/findId")
    public String findId(@RequestParam String userEmail, Model model) {
        String idByEmail = loginService.findIdByEmail(userEmail);
        if (idByEmail != null) {
            model.addAttribute("id", idByEmail);
        } else {
            model.addAttribute("error", "이메일을 찾을 수 없습니다.");
        }
        return "findId";
    }

    @GetMapping("/findPwd")
    public String findPwdPage() {
        return "findPwd";
    }

    @PostMapping("/findPwd")
    public String findPwd(@RequestParam String userEmail, Model model) {
        String pwdByEmail = loginService.findPwdByEmail(userEmail);
        if (pwdByEmail != null) {
            model.addAttribute("pwd", pwdByEmail);
        } else {
            model.addAttribute("error", "이메일을 찾을 수 없습니다.");
        }
        return "findPwd";
    }
}
