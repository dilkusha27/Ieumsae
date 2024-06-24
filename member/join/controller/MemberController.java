package com.ieumsae.project.member.join.controller;

import com.ieumsae.project.member.join.dto.MemberDTO;
import com.ieumsae.project.member.join.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {


    private final MemberService memberService;

    //생성자 함수
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/register")
    public String registraionFrom(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        // addAtrribute는 뷰에 전달하는 역할
        return "register";
    }

    @PostMapping("/register")
    public String registerMember(@ModelAttribute MemberDTO memberDTO, Model model) {
        try {
            if (!memberService.isUserIdDuplicate(memberDTO.getUserId()) && memberService.joinMember(memberDTO)) {
                model.addAttribute("message", "회원가입에 성공했습니다.");
                return "index";
            } else {
                model.addAttribute("message", "회원가입을 다시 시도해주세요.");
                return "register";
            }
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }

    }


}
