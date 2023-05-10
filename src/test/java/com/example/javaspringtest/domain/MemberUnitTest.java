package com.example.javaspringtest.domain;

import com.example.javaspringtest.domain.member.Member;
import com.example.javaspringtest.domain.member.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberUnitTest {

    private static final MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeAll
    static void init() {
        Member member = new Member(1L, "bellCold", "010-1234-1234");
        memberRepository.save(member);
    }

    @Test
    @Order(1)
    void findMemberTest() {
        Member findMember = memberRepository.findId(1L);
        assertThat(findMember.getName()).isEqualTo("bellCold");
    }

    @Test
    @Order(2)
    void updateMemberTest() {
        Member findMember = memberRepository.findId(1L);
        memberRepository.update(new Member(findMember.getId(), "changeName", findMember.getPhone()));

        Member updateMember = memberRepository.findId(1L);
        assertThat(updateMember.getName()).isEqualTo("changeName");
    }

    @Test
    @Order(3)
    void removeMemberTest() {

    }

}
