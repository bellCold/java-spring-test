package com.example.javaspringtest.domain;

import com.example.javaspringtest.domain.member.JpaMemberRepository;
import com.example.javaspringtest.domain.member.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import static com.example.javaspringtest.domain.member.QMember.member;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class QuerydslTest {

    private final JpaMemberRepository jpaMemberRepository;
    private final JPAQueryFactory queryFactory;

    public QuerydslTest(JpaMemberRepository jpaMemberRepository, JPAQueryFactory queryFactory) {
        this.jpaMemberRepository = jpaMemberRepository;
        this.queryFactory = queryFactory;
    }

    @BeforeEach
    void init() {
        Member member = new Member(1L, "test", "010");
        jpaMemberRepository.save(member);
    }

    @AfterEach
    void rollBack() {
        jpaMemberRepository.deleteAll();
    }


    @Test
    void querydslTest() {
        Member findMember = queryFactory.selectFrom(member)
                .where(member.id.eq(1L))
                .fetchFirst();

        assertThat(findMember.getName()).isEqualTo("test");
    }
}
