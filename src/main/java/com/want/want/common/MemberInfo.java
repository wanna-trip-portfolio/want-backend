package com.want.want.common;

import com.want.want.dto.session.MemberSession;
import lombok.Getter;

import javax.servlet.http.HttpServletRequest;

@Getter
public class MemberInfo {

    private Long memberId;

    public MemberInfo(HttpServletRequest request) {
        MemberSession memberSession = (MemberSession) request.getSession().getAttribute("memberInfo");
        if (memberSession != null) {
            this.memberId = memberSession.getMemberId();
        }
    }
}
