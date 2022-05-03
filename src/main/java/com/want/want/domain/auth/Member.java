package com.want.want.domain.auth;

import com.want.want.dto.auth.MemberJoinReqDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter @Setter
@DynamicInsert
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
    private String birth;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @ColumnDefault("'U'")
    private String memberType;

    private LocalDateTime localDateTime = LocalDateTime.now();

    public Member() {

    }

    public Member(MemberJoinReqDto reqDto) {
        this.webId = reqDto.getWebId();
        this.webPw = reqDto.getWebPw();
        this.name = reqDto.getName();
        this.birth = reqDto.getBirth();
        this.email = reqDto.getEmail();
        this.phoneNumber = reqDto.getPhoneNumber();
    }
}
