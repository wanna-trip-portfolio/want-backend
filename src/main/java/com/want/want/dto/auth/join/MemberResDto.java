package com.want.want.dto.auth.join;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberResDto {

    private Long id;
    private String webId;
    private String webPw;
    private String name;
    private String birth;
    private String email;
    private String phoneNumber;

}
