package com.ieumsae.project.member.join.service;

import com.ieumsae.project.member.join.dto.MemberDTO;
import com.ieumsae.project.member.join.model.MemberInterestModel;
import com.ieumsae.project.member.join.model.MemberModel;
import com.ieumsae.project.member.join.repository.MemberInterestRepository;
import com.ieumsae.project.member.join.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class MemberServiceImpl implements MemberService {

    //의존성
    private final MemberRepository memberRepository;
    private final MemberInterestRepository memberInterestRepository;

    //생성자 함수
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, MemberInterestRepository memberInterestRepository) {
        this.memberRepository = memberRepository;
        this.memberInterestRepository = memberInterestRepository;
    }

    @Override
    public boolean isUserIdDuplicate(String userId) {
        return memberRepository.findByUserId(userId).isPresent();
    }
    //findByUserID의 내부 로직 sql: SELECT m FROM MemberModel m WHERE m.userId = :userId

    @Override
    public boolean isPrivacyPolicyAgreed(boolean privacyPolicy) {
        return privacyPolicy;
    }

    @Override
    @Transactional
    public boolean joinMember(MemberDTO memberDTO) {
        if (isUserIdDuplicate(memberDTO.getUserId())) {
            return false; // 아이디가 이미 존재하는 경우 가입 실패
        }

        if (!memberDTO.getUserPwd().equals(memberDTO.getUserPwdCheck())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        if (!isPrivacyPolicyAgreed(memberDTO.isPrivacyPolicy())) {
            throw new IllegalArgumentException("개인정보 보호 정책에 동의하지 않았습니다.");
        }

        MemberModel memberModel = new MemberModel();
        memberModel.setUserId(memberDTO.getUserId());
        memberModel.setUserPwd(memberDTO.getUserPwd());
        memberModel.setUserCertification(memberDTO.getUserCertification());
        memberModel.setUserNickName(memberDTO.getUserNickName());
        memberModel.setUserGender(memberDTO.getUserGender());
        memberModel.setUserMbti(memberDTO.getUserMbti());
        memberModel.setUserName(memberDTO.getUserName());
        memberModel.setUserPhoneNum(memberDTO.getUserPhoneNum());
        memberModel.setUserEmail(memberDTO.getUserEmail());
        memberModel.setUserAddress(memberDTO.getUserAddress());
        memberModel.setUserJoinDate(LocalDate.now());
        memberModel.setUserGrade(memberDTO.getUserGrade());
        memberModel.setPrivacyPolicy(memberDTO.isPrivacyPolicy());
        memberRepository.save(memberModel);

        MemberInterestModel memberInterestModel = new MemberInterestModel();
        memberInterestModel.setUserInterest1(memberDTO.getUserInterest1());
        memberInterestModel.setUserInterest2(memberDTO.getUserInterest2());
        memberInterestModel.setUserRegion1(memberDTO.getUserRegion1());
        memberInterestModel.setUserRegion2(memberDTO.getUserRegion2());
        memberInterestRepository.save(memberInterestModel);

        return true; // 가입 성공
    }
}
