package com.train.member.controller;

import com.train.common.resp.CommonResp;
import com.train.member.req.MemberLoginReq;
import com.train.member.req.MemberRegisterReq;
import com.train.member.req.MemberSendCodeReq;
import com.train.member.resp.MemberLoginResp;
import com.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count() {
        CommonResp<Integer> commonResp = new CommonResp<>();
        commonResp.setContent(memberService.count());
        return commonResp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq memberRegisterReq) {
      /*  CommonResp<Long> commonResp = new CommonResp<>();
        commonResp.setContent(memberService.register(memberRegisterReq));
        return commonResp;*/
        long register = memberService.register(memberRegisterReq);
        return new CommonResp<>(register);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid MemberSendCodeReq memberSendCodeReq) {
        memberService.sendCode(memberSendCodeReq);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }

}
