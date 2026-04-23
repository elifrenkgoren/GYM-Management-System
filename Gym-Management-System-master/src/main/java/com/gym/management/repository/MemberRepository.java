package com.gym.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gym.management.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}