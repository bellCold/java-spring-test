package com.example.javaspringtest.domain;

import com.example.javaspringtest.domain.member.Member;
import com.example.javaspringtest.domain.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class MemberTest {

    private final MemberRepository memberRepository;

    private MemberTest(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    void createMember() {
        Member member = new Member(1L, "queryDsa", "010");
        memberRepository.save(member);
        Member findMember = memberRepository.findId(1L);
        System.out.println("findMember = " + findMember.getName());
    }
}