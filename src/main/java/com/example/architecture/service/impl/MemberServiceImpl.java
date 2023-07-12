package com.example.architecture.service.impl;

import com.example.architecture.model.entity.Member;
import com.example.architecture.model.request.MemberRequest;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.service.MemberService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member, MemberRequest, MemberResponse, MemberRepository> implements MemberService {

    public MemberServiceImpl(MemberRepository repository) {
        super(repository);
    }

    @Override
    public Member update(MemberRequest request) {
        try {
            return null;
        } catch (Exception e) {
            throw  e;
        }
    }
}
