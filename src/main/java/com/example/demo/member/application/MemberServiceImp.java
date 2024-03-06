package com.example.demo.member.application;

import com.example.demo.member.domain.Member;
import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.dto.ModifyPasswordDto;
import com.example.demo.member.infrastructor.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImp implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void modifyUserPwd(ModifyPasswordDto modifyPwdDto, Object userId) {

    }

    @Override
    public Member createMember(MemberDto memberDto) {
        return memberRepository.save(Member.builder()
                .password(memberDto.getPassword())
                .name(memberDto.getName())
                .phone(memberDto.getPhone())
                .email(memberDto.getEmail())
                .address(memberDto.getAddress())
                .build());
    }

    @Override
    public Member getMember(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
