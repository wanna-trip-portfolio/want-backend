package com.want.want;

import com.want.want.dto.session.MemberSession;
import com.want.want.exception.UnauthorizedAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestController {

    @GetMapping("/test1")
    public MemberSession testSession(HttpSession session) throws UnauthorizedAccessException {
        System.out.println("session = " + session.getId());
        MemberSession memberInfo = (MemberSession) session.getAttribute("memberInfo");
        System.out.println("memberInfo = " + memberInfo);
        if(memberInfo == null) throw new UnauthorizedAccessException("바보바보");
        return memberInfo;
    }

    @GetMapping("/test2")
    public String testSession2(HttpSession session) {
        session.removeAttribute("memberInfo");
        return "delete ok";
    }


}
