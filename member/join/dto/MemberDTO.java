package com.ieumsae.project.member.join.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MemberDTO {

    private String userId; // 아이디
    private String userPwd; // 비밀번호
    private String userPwdCheck; // 비밀번호
    private int userCertification = 1; // 회원가입 방식 (웹사이트 회원가입)
    private String userNickName; // 닉네임
    private int userGender; // 성별
    private String userMbti; // MBTI
    private String userName; // 이름
    private String userPhoneNum; // 전화번호
    private String userEmail; // 이메일
    private String userAddress; // 주소
    private LocalDate userJoinDate; // 가입일자
    private int userGrade = 1; // 등급
    private int userInterest1; // 관심분야1
    private int userInterest2; // 관심분야2
    private int userRegion1; // 관심지역1
    private int userRegion2; // 관심지역2
    private boolean privacyPolicy; // 개인정보 처리방침 동의 여부

    // Getter and Setter => lombok


}
