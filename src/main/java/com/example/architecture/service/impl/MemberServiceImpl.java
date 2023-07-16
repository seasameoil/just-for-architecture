package com.example.architecture.service.impl;

import com.example.architecture.model.entity.Member;
import com.example.architecture.model.request.MemberRequest;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.service.MemberService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member, MemberRequest, MemberResponse, MemberRepository> implements MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ModelMapper modelMapper;

    public MemberServiceImpl(MemberRepository repository) {
        super(repository);
    }

    @Override
    public MemberResponse update(MemberRequest request, Long id) throws Exception {
        try {

            Member member = memberRepository.findById(id).get();
            member.update(request);

            return modelMapper.map(request, MemberResponse.class);
        } catch (Exception e) {
            throw  e;
        }
    }
}
