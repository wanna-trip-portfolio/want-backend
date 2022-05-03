package com.want.want.apiController;

import com.want.want.common.DataStatusMessage;
import com.want.want.common.WantResBody;
import com.want.want.dto.auth.MemberJoinReqDto;
import com.want.want.service.auth.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @PostMapping("/sign-up")
    public ResponseEntity<WantResBody> postMemberSignUp(@RequestBody MemberJoinReqDto reqDto) {
        memberService.createMember(reqDto);
        return ResponseEntity.ok(WantResBody.success(DataStatusMessage.INSERT_SUCCESS));
    }
}
