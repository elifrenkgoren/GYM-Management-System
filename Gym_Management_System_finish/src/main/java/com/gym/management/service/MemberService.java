package com.gym.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.management.entity.Member;
import com.gym.management.repository.MemberRepository;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

   
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    
    public void saveMember(Member member) {
        memberRepository.save(member);
    }
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}