package com.example.javaspringtest.api;

import com.example.javaspringtest.api.request.MemberRequestDto;
import com.example.javaspringtest.domain.member.Member;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MemberMapper extends EntityMapper<MemberRequestDto, Member> {

    MemberMapper MAPPER = Mappers.getMapper(MemberMapper.class);
}
