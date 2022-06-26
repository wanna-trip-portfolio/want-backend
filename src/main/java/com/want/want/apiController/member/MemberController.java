package com.want.want.apiController.member;

import com.want.want.common.DataStatusMessage;
import com.want.want.common.WantResBody;
import com.want.want.dto.member.join.MemberJoinReqDto;
import com.want.want.dto.member.login.LoginDto;
import com.want.want.dto.session.MemberSession;
import com.want.want.exception.UnauthorizedAccessException;
import com.want.want.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 아이디 중복검사
    @GetMapping("/duplicate-check/web-id/{webId}")
    public ResponseEntity<WantResBody> getMemberDuplicateCheckWebId(@PathVariable String webId) {
        boolean message = memberService.checkMemberWebId(webId);
        return ResponseEntity.ok(WantResBody.success(message));
    }

    // 닉네임 중복검사
    @GetMapping("/duplicate-check/nickname/{nickName}")
    public ResponseEntity<WantResBody> getMemberDuplicateCheckNickName(@PathVariable String nickName) {
        boolean message = memberService.checkMemberNickName(nickName);
        return ResponseEntity.ok(WantResBody.success(message));
    }

    // 이메일 중복검사
    @GetMapping("/duplicate-check/email/{email}")
    public ResponseEntity<WantResBody> getMemberDuplicateCheckEmail(@PathVariable String email) {
        boolean message = memberService.checkMemberEmail(email);
        return ResponseEntity.ok(WantResBody.success(message));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<WantResBody> postMemberSignUp(@RequestBody MemberJoinReqDto reqDto) {
        memberService.createMember(reqDto);
        return ResponseEntity.ok(WantResBody.success(DataStatusMessage.INSERT_SUCCESS));
    }

    @PostMapping("/login")
    public ResponseEntity<WantResBody> postLogin(@RequestBody LoginDto loginDto,
                                                 HttpServletRequest request) throws UnauthorizedAccessException {
        MemberSession result = memberService.login(loginDto, request);
        return ResponseEntity.ok(WantResBody.success(result));
    }

    @GetMapping("/logout")
    public ResponseEntity<WantResBody> logoutMember(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok(WantResBody.success(DataStatusMessage.LOGOUT_SUCCESS));
    }
}
