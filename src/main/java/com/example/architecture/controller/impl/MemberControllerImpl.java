package com.example.architecture.controller.impl;

import com.example.architecture.controller.MemberController;
import com.example.architecture.controller.generic.impl.BaseControllerImpl;
import com.example.architecture.model.entity.Member;
import com.example.architecture.model.request.LoginRequest;
import com.example.architecture.model.request.MemberRequest;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.service.generic.BaseService;
import com.example.architecture.service.impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/member")
public class MemberControllerImpl extends BaseControllerImpl<Member, MemberRequest, MemberResponse, MemberRepository> implements MemberController {

    @Autowired
    MemberServiceImpl memberService;

    public MemberControllerImpl(BaseService<Member, MemberRequest, MemberResponse, MemberRepository> baseService) {
        super(baseService);
    }

    @PostMapping("/login")
    public String login(@RequestPart(name = "login")LoginRequest loginRequest) {

        String tokenInfo = memberService.login(loginRequest);
        return tokenInfo;
    }
}
