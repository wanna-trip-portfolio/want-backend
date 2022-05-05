package com.want.want.apiController.auth;

import com.want.want.common.DataStatusMessage;
import com.want.want.common.WantResBody;
import com.want.want.dto.auth.join.MemberJoinReqDto;
import com.want.want.dto.auth.login.LoginDto;
import com.want.want.dto.auth.login.LoginInfoDto;
import com.want.want.service.auth.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @GetMapping("/duplicate-check/{webId}")
    public ResponseEntity<WantResBody> getMemberDuplicateCheck(@PathVariable String webId) {
        boolean message = memberService.checkMemberWebId(webId);
        return ResponseEntity.ok(WantResBody.success(message));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<WantResBody> postMemberSignUp(@RequestBody MemberJoinReqDto reqDto) {
        memberService.createMember(reqDto);
        return ResponseEntity.ok(WantResBody.success(DataStatusMessage.INSERT_SUCCESS));
    }

    /*@PostMapping("/login")
    public ResponseEntity<WantResBody> postMemberLogin(@RequestBody LoginDto loginDto) {
        LoginInfoDto result = memberService.loginMember(loginDto);
        return ResponseEntity.ok(WantResBody.success(result));
    }*/
}
