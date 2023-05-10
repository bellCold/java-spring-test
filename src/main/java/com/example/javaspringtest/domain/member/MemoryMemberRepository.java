package com.example.javaspringtest.domain.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    private final Map<Long, Member> repository = new HashMap<>();

    @Override
    public void save(Member member) {
        repository.put(member.getId(), member);
    }

    @Override
    public void update(Member member) {
        repository.remove(member.getId());
        repository.put(member.getId(), member);
    }

    @Override
    public void remove(Member member) {
        repository.remove(member.getId());
    }

    @Override
    public Member findId(Long id) {
        return repository.get(id);
    }
}
