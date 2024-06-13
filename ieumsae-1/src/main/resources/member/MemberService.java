package member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean isIdAvailable(String userId) {
        return !memberRepository.existsByUserId(userId);
    }

    public boolean setNickname(Long memberId, String nickname) {
        Optional<MemberModel> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            MemberModel member = memberOptional.get();
            member.setNickname(nickname);
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    public boolean confirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public void setGender(Long memberId, String gender) {
        Optional<MemberModel> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            MemberModel member = memberOptional.get();
            member.setGender(gender);
            memberRepository.save(member);
        }
    }

    public void setMbti(Long memberId, String mbti) {
        Optional<MemberModel> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            MemberModel member = memberOptional.get();
            member.setMbti(mbti);
            memberRepository.save(member);
        }
    }

    public boolean verifyPhone(String phoneNumber, String code) {
        // 휴대폰 인증 로직
        // 이 부분은 실제로 외부 API 호출이나 인증 코드를 확인하는 로직이 들어가야 합니다.
        return true;
    }

    public boolean verifyEmail(String email, String code) {
        // 이메일 인증 로직
        // 이 부분은 실제로 외부 API 호출이나 인증 코드를 확인하는 로직이 들어가야 합니다.
        return true;
    }

    public void setInterests(Long memberId, List<String> interests) {
        Optional<MemberModel> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            MemberModel member = memberOptional.get();
            member.setInterests(interests);
            memberRepository.save(member);
        }
    }

    public void setRegions(Long memberId, List<String> regions) {
        Optional<MemberModel> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            MemberModel member = memberOptional.get();
            member.setRegions(regions);
            memberRepository.save(member);
        }
    }

    public boolean isZipcodeValid(String zipcode) {
        // 우편번호 유효성 검사 로직
        // 실제로 우편번호 유효성을 확인하는 로직이 필요합니다.
        return true;
    }

    public void acceptPrivacyPolicy(Long memberId) {
        Optional<MemberModel> memberOptional = memberRepository.findById(memberId);
        if (memberOptional.isPresent()) {
            MemberModel member = memberOptional.get();
            member.setPrivacyPolicyAccepted(true);
            memberRepository.save(member);
        }
    }

    public boolean registerMember(MemberModel member) {
        if (!memberRepository.existsByUserId(member.getUserId())) {
            memberRepository.save(member);
            return true;
        }
        return false;
    }
}
