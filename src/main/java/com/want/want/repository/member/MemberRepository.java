package com.want.want.repository.member;

import com.want.want.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByWebId(String webId);

    Member findByNickName(String nickName);

    Member findByEmail(String email);

    Member findByWebIdAndWebPw(String webId, String webPw);
}
