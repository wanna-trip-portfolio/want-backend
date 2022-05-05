package com.want.want.service.auth;

import com.want.want.domain.auth.Member;
import com.want.want.dto.auth.join.MemberJoinReqDto;
import com.want.want.dto.auth.login.LoginDto;
import com.want.want.dto.auth.login.LoginInfoDto;
import com.want.want.repository.auth.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public boolean checkMemberWebId(String webId) {
        return memberRepository.findByWebId(webId);
    }

    public void createMember(MemberJoinReqDto reqDto) {
        Member member = new Member(reqDto);
        memberRepository.save(member);
    }

    /*public LoginInfoDto loginMember(LoginDto loginDto) {

    }*/
}
