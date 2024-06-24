package com.ieumsae.project.member.join.service;

import com.ieumsae.project.member.join.dto.MemberDTO;

public interface MemberService {

    boolean isUserIdDuplicate(String userId); // 아이디 중복 확인

    boolean joinMember(MemberDTO memberDTO); // 회원 가입

    boolean isPrivacyPolicyAgreed(boolean privacyPolicy); // 개인정보 처리방침 동의 여부 확인

}
