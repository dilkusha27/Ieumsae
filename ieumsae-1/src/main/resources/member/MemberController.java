package member;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    @GetMapping("/check-id")
    public ResponseEntity<String> checkId(@RequestParam String id) {
        boolean isAvailable = memberService.isIdAvailable(id);
        if (isAvailable) {
            return ResponseEntity.ok("사용 가능한 아이디입니다.");
        } else {
            return ResponseEntity.status(409).body("이미 사용 중인 아이디입니다.");
        }
    }

    @PostMapping("/set-nickname")
    public ResponseEntity<String> setNickname(@RequestParam Long memberId, @RequestParam String nickname) {
        boolean isSuccess = memberService.setNickname(memberId, nickname);
        if (isSuccess) {
            return ResponseEntity.ok("닉네임 설정 성공");
        } else {
            return ResponseEntity.status(400).body("닉네임 설정 실패");
        }
    }

    @PostMapping("/confirm-password")
    public ResponseEntity<String> confirmPassword(@RequestParam String password, @RequestParam String confirmPassword) {
        boolean isMatch = memberService.confirmPassword(password, confirmPassword);
        if (isMatch) {
            return ResponseEntity.ok("비밀번호가 일치합니다.");
        } else {
            return ResponseEntity.status(400).body("비밀번호가 일치하지 않습니다.");
        }
    }

    @PostMapping("/check-age")
    public ResponseEntity<String> checkAge(@RequestParam int age) {
        if (age >= 19) {
            return ResponseEntity.ok("성인입니다.");
        } else {
            return ResponseEntity.status(400).body("성인이 아닙니다.");
        }
    }

    @PostMapping("/set-gender")
    public ResponseEntity<String> setGender(@RequestParam Long memberId, @RequestParam String gender) {
        memberService.setGender(memberId, gender);
        return ResponseEntity.ok("성별 설정 완료");
    }

    @PostMapping("/set-mbti")
    public ResponseEntity<String> setMbti(@RequestParam Long memberId, @RequestParam String mbti) {
        memberService.setMbti(memberId, mbti);
        return ResponseEntity.ok("MBTI 설정 완료");
    }

    @PostMapping("/phone-auth")
    public ResponseEntity<String> phoneAuth(@RequestParam String phoneNumber, @RequestParam String code) {
        boolean isSuccess = memberService.verifyPhone(phoneNumber, code);
        if (isSuccess) {
            return ResponseEntity.ok("휴대폰 인증 성공");
        } else {
            return ResponseEntity.status(400).body("휴대폰 인증 실패");
        }
    }

    @PostMapping("/email-auth")
    public ResponseEntity<String> emailAuth(@RequestParam String email, @RequestParam String code) {
        boolean isSuccess = memberService.verifyEmail(email, code);
        if (isSuccess) {
            return ResponseEntity.ok("이메일 인증 성공");
        } else {
            return ResponseEntity.status(400).body("이메일 인증 실패");
        }
    }

    @PostMapping("/set-interests")
    public ResponseEntity<String> setInterests(@RequestParam Long memberId, @RequestBody List<String> interests) {
        memberService.setInterests(memberId, interests);
        return ResponseEntity.ok("관심분야 설정 완료");
    }

    @PostMapping("/set-regions")
    public ResponseEntity<String> setRegions(@RequestParam Long memberId, @RequestBody List<String> regions) {
        memberService.setRegions(memberId, regions);
        return ResponseEntity.ok("관심지역 설정 완료");
    }

    @GetMapping("/check-zipcode")
    public ResponseEntity<String> checkZipcode(@RequestParam String zipcode) {
        boolean isValid = memberService.isZipcodeValid(zipcode);
        if (isValid) {
            return ResponseEntity.ok("유효한 우편번호입니다.");
        } else {
            return ResponseEntity.status(400).body("유효하지 않은 우편번호입니다.");
        }
    }

    @PostMapping("/accept-privacy-policy")
    public ResponseEntity<String> acceptPrivacyPolicy(@RequestParam Long memberId, @RequestParam boolean accept) {
        if (accept) {
            memberService.acceptPrivacyPolicy(memberId);
            return ResponseEntity.ok("개인정보 처리방침 동의 완료");
        } else {
            return ResponseEntity.status(400).body("개인정보 처리방침 동의 필요");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MemberModel member) {
        logger.info("회원 가입 요청: {}", member);
        boolean isSuccess = memberService.registerMember(member);
        if (isSuccess) {
            return ResponseEntity.ok("회원가입 성공");
        } else {
            return ResponseEntity.status(400).body("회원가입 실패");
        }
    }
}
