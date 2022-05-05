package com.want.want.repository.auth;

import com.want.want.domain.auth.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean findByWebId(String webId);
}
