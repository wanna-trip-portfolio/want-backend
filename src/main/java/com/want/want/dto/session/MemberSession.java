package com.want.want.dto.session;

import com.want.want.constant.Role;
import com.want.want.dto.member.login.LoginInfoDto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class MemberSession implements Serializable {

    private Long memberId;
    private String webId;
    private String name;
    private String nickName;
    private Role role;

    public MemberSession(LoginInfoDto infoDto) {
        this.memberId = infoDto.getMemberId();
        this.webId = infoDto.getWebId();
        this.name = infoDto.getName();
        this.nickName = infoDto.getNickName();
        this.role = infoDto.getRole();
    }

    public MemberSession(MemberSession memberSession) {
        this.memberId = memberSession.getMemberId();
        this.webId = memberSession.getWebId();
        this.name = memberSession.getName();
        this.nickName = memberSession.getNickName();
        this.role = memberSession.getRole();
    }
}
