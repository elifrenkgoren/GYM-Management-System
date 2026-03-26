package com.gym.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gym.management.entity.Member;
import com.gym.management.repository.MemberRepository;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members")
    public String listMembers(Model model){
        model.addAttribute("members", memberRepository.findAll());
        return "members";
    }

    @GetMapping("/add-member")
    public String showForm(Model model){
        model.addAttribute("member", new Member());
        return "add-member";
    }

    @PostMapping("/save-member")
    public String saveMember(Member member){
        memberRepository.save(member);
        return "redirect:/members";
    }
}