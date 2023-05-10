package com.example.javaspringtest.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMemberRepository extends JpaRepository<Member, Long> {
}
