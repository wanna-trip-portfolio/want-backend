package com.want.want.service.member;

import com.want.want.domain.member.Member;
import com.want.want.dto.member.join.MemberJoinReqDto;
import com.want.want.dto.member.login.LoginDto;
import com.want.want.dto.member.login.LoginInfoDto;
import com.want.want.dto.session.MemberSession;
import com.want.want.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public boolean checkMemberWebId(String webId) {
        Member findWebId = memberRepository.findByWebId(webId);
        return findWebId == null;
    }

    public boolean checkMemberNickName(String nickName) {
        Member findNickName = memberRepository.findByNickName(nickName);
        return findNickName == null;
    }

    public boolean checkMemberEmail(String email) {
        Member findEmail = memberRepository.findByEmail(email);
        return findEmail == null;
    }

    public void createMember(MemberJoinReqDto reqDto) {
        Member member = new Member(reqDto);
        memberRepository.save(member);
    }

    public MemberSession login(LoginDto loginDto, HttpServletRequest request) {
        Member member = memberRepository.findByWebIdAndWebPw(loginDto.getWebId(), loginDto.getWebPw());
        LoginInfoDto infoDto = new LoginInfoDto(member);
        return createSession(infoDto, request);
    }

    private MemberSession createSession(LoginInfoDto infoDto, HttpServletRequest request) {
        MemberSession memberSession = new MemberSession(infoDto);

        HttpSession session = request.getSession();
        session.setAttribute("memberInfo", memberSession);

        return memberSession;
    }

}
