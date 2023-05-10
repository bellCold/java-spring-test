package com.example.javaspringtest.domain.member;

public interface MemberRepository {

    void save(Member member);

    void update(Member member);

    void remove(Member member);

    Member findId(Long id);
}
