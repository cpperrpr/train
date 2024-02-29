package com.suiwu.train.member.controller;

import com.suiwu.train.common.resp.CommonResp;
import com.suiwu.train.member.req.MemberLoginReq;
import com.suiwu.train.member.req.MemberRegisterReq;
import com.suiwu.train.member.req.MemberSendCodeReq;
import com.suiwu.train.member.resp.MemberLoginResp;
import com.suiwu.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;
    @GetMapping("/count")
    public CommonResp<Integer> count(){
        int count = memberService.count();
        CommonResp<Integer> commonResp = new CommonResp<>();
        commonResp.setContent(count);
        return commonResp;
    }
    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req){
        long register =  memberService.register(req);
//        CommonResp<Long> commonResp = new CommonResp<>();
//        commonResp.setContent(register);
//        return commonResp;
        return new CommonResp<>(register);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req){
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> sendCode(@Valid @RequestBody MemberLoginReq req){
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }


}
