package com.want.want.dto.member.login;

import com.want.want.constant.Role;
import com.want.want.domain.member.Member;
import lombok.Data;


@Data
public class LoginInfoDto {

    private Long memberId;
    private String webId;
    private String webPw;
    private String name;
    private String nickName;
    private Role role;


    public LoginInfoDto(Member member) {
        this.memberId = member.getMemberId();
        this.webId = member.getWebId();
        this.webPw = member.getWebPw();
        this.name = member.getName();
        this.nickName = member.getNickName();
        this.role = member.getRole();
    }
}
