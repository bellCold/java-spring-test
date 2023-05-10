package com.example.javaspringtest.global.config;

import com.example.javaspringtest.domain.member.MemberRepository;
import com.example.javaspringtest.domain.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
