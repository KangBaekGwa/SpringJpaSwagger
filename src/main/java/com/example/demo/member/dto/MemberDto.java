package com.example.demo.member.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
}
