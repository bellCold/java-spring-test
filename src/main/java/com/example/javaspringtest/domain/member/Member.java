package com.example.javaspringtest.domain.member;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private Long id;

    private String name;

    private String phone;

    public Member(Long id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}
