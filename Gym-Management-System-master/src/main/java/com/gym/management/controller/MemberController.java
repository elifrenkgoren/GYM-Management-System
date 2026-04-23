package com.gym.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gym.management.entity.Member;
import com.gym.management.service.MemberService;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public String listMembers(Model model){
        model.addAttribute("members", memberService.getAllMembers());
        return "members";
    }

    @GetMapping("/add-member")
    public String showForm(Model model){
        model.addAttribute("member", new Member());
        return "add-member";
    }

    @PostMapping("/save-member")
    public String saveMember(Member member){
        memberService.saveMember(member);
        return "redirect:/members";
    }
    @GetMapping("/delete-member/{id}")
    public String deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return "redirect:/members";
    }
    @GetMapping("/edit-member/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Member member = memberService.getMemberById(id);
        model.addAttribute("member", member);
        return "edit-member";
    }
    @PostMapping("/update-member")
    public String updateMember(Member member){
        memberService.saveMember(member);
        return "redirect:/members";
    }
    
}