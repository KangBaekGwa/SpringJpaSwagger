package com.example.demo.member.application;

import com.example.demo.member.domain.Member;
import com.example.demo.member.dto.MemberDto;
import com.example.demo.member.dto.ModifyPasswordDto;

//usecase 가 될꺼다.
public interface MemberService {

    void modifyUserPwd(ModifyPasswordDto modifyPwdDto, Object userId);
    Member createMember(MemberDto memberDto);

    Member getMember(Long id);
}
