package com.example.architecture.controller.impl;

import com.example.architecture.controller.MemberController;
import com.example.architecture.controller.generic.impl.BaseControllerImpl;
import com.example.architecture.model.entity.Member;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.service.generic.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/member")
public class MemberControllerImpl extends BaseControllerImpl<Member, MemberRepository> implements MemberController {

    public MemberControllerImpl(BaseService<Member, MemberRepository> baseService) {
        super(baseService);
    }
}
