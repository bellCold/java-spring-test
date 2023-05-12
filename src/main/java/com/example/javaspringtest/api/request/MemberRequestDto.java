package com.example.javaspringtest.api.request;

import com.example.javaspringtest.domain.member.Member;

public record MemberRequestDto(Long id, String name, String phone) {

}
