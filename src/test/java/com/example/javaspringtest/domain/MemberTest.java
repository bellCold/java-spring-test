package com.example.javaspringtest.domain;

import com.example.javaspringtest.api.request.MemberRequestDto;
import com.example.javaspringtest.domain.member.JpaMemberRepository;
import com.example.javaspringtest.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import static com.example.javaspringtest.api.MemberMapper.MAPPER;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class MemberTest {

    private final JpaMemberRepository memberRepository;

    MemberTest(JpaMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Test
    void createMember() {
        MemberRequestDto requestDto = new MemberRequestDto(3L, "bellCold", "010-1234-1234");
        Member member = MAPPER.toEntity(requestDto);
        memberRepository.save(member);

        Member findMember = memberRepository.findById(3L).orElseThrow(RuntimeException::new);

        assertThat(findMember.getName()).isEqualTo("bellCold");
    }
}