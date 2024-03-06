package com.example.demo.member.presentation;


import com.example.demo.member.application.MemberService;
import com.example.demo.member.domain.Member;
import com.example.demo.member.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
@Tag(name = "User API", description = "USER_API")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberController {

    private final MemberService memberService;

    public void modifyUserPwd(){

    }

    @PostMapping
    @Tag(name = "User API")
    @Operation(summary = "User 생성", description = "User 정보를 생성합니다.")
    public Member createMember(@RequestBody MemberDto memberDto){
        return memberService.createMember(memberDto);
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable("id") Long id){
        return memberService.getMember(id);
    }
}
