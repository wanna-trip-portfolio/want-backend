package com.want.want.domain.auth;

import com.want.want.dto.auth.MemberJoinReqDto;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @Column(nullable = false)
    private String webId;

    @Column(nullable = false)
    private String webPw;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = true)
    private String nickName;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;


    private LocalDateTime localDateTime = LocalDateTime.now();

    public Member() {

    }

    public Member(MemberJoinReqDto reqDto) {
        this.webId = reqDto.getWebId();
        this.webPw = reqDto.getWebPw();
        this.name = reqDto.getName();
        this.gender = reqDto.getGender();
        this.nickName = reqDto.getNickName();
        this.birth = reqDto.getBirth();
        this.email = reqDto.getEmail();
        this.phoneNumber = reqDto.getPhoneNumber();
        this.role = Role.USER;
    }
}
