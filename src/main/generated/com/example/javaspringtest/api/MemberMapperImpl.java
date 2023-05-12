package com.example.javaspringtest.api;

import com.example.javaspringtest.api.request.MemberRequestDto;
import com.example.javaspringtest.domain.member.Member;
import com.example.javaspringtest.domain.member.Member.MemberBuilder;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-12T12:45:14+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member toEntity(MemberRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        MemberBuilder member = Member.builder();

        member.id( dto.id() );
        member.name( dto.name() );
        member.phone( dto.phone() );

        return member.build();
    }

    @Override
    public MemberRequestDto toDto(Member entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String phone = null;

        id = entity.getId();
        name = entity.getName();
        phone = entity.getPhone();

        MemberRequestDto memberRequestDto = new MemberRequestDto( id, name, phone );

        return memberRequestDto;
    }
}
