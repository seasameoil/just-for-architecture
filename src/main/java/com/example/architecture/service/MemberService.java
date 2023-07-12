package com.example.architecture.service;

import com.example.architecture.model.entity.Member;
import com.example.architecture.model.request.MemberRequest;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.service.generic.BaseService;

public interface MemberService extends BaseService<Member, MemberRequest, MemberResponse, MemberRepository> {

    Member update(MemberRequest request);
}
