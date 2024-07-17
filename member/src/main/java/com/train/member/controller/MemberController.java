package com.train.member.controller;

import com.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @GetMapping("/count")
    public Integer count(){
        return memberService.count();
    }

   @PostMapping("/register")
    public long register(String phone){
        return memberService.register(phone);
    }

}
