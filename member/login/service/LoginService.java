package com.ieumsae.project.member.login.service;

import ch.qos.logback.core.model.Model;

public interface LoginService {

    public boolean login(String userId, String userPwd);

    public String findIdByEmail(String userEmail);

    public String findPwdByEmail(String userEmail);

}
