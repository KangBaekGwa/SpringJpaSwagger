package com.example.demo.member.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_password", nullable = false)
    private String password;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_email", nullable = false)
    private String email;

    @Column(name = "member_phone", nullable = false)
    private String phone;

    @Column(name = "member_address", nullable = false)
    private String address;

    @Column(name = "member_gender", columnDefinition = "TINYINT", length = 1, nullable = true)
    private Short gender;

    @Builder
    public Member(String password, String name, String email, String phone, String address) {
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
