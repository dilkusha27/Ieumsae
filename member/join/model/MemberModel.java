package com.ieumsae.project.member.join.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "member")
@Getter
@Setter
public class MemberModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private Long idx; // 회원번호

    @Column(name = "user_id")
    private String userId; // 아이디

    @Column(name = "user_pw")
    private String userPwd; // 비밀번호

    @Column(name = "user_certification")
    private int userCertification = 1; // 인증방식 (웹사이트 회원가입)

    @Column(name = "user_nick_name")
    private String userNickName; // 닉네임

    @Column(name = "user_sex")
    private int userGender; // 성별

    @Column(name = "user_mbti")
    private String userMbti; // MBTI

    @Column(name = "user_name")
    private String userName; // 이름

    @Column(name = "user_phone")
    private String userPhoneNum; // 전화번호

    @Column(name = "user_email")
    private String userEmail; // 이메일

    @Column(name = "user_address")
    private String userAddress; // 주소

    @Column(name = "user_join_date", updatable = false, insertable = false, columnDefinition = "datetime default current_timestamp")
    private LocalDate userJoinDate; // 가입일자

    @Column(name = "user_grade", columnDefinition = "int default 1")
    private int userGrade = 1; // 등급

    private boolean privacyPolicy; // 개인정보 처리방침 동의 여부

    // Getter and Setter => lombok

    }
