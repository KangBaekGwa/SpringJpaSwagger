package com.example.demo.member.infrastructor;

import com.example.demo.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByGender(short gender);

    Optional<Member> findByLoginId(String LoginId);
}
