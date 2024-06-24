package com.ieumsae.project.member.login.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
public class LoginModel {

    @Id
    @Column(name = "user_idx")
    private int userIdx;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;
}
