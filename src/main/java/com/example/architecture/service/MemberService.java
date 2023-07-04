package com.example.architecture.service;

import com.example.architecture.interfaces.CrudInterface;
import com.example.architecture.model.entity.Member;
import com.example.architecture.model.request.MemberRequest;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService implements CrudInterface<MemberRequest, MemberResponse> {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberResponse create(MemberRequest request) {

        Member member = Member.builder()
                .memberName(request.getMemberName())
                .nickName(request.getNickName())
                .password(request.getPassword())
                .build();

        Member newMember = memberRepository.save(member);

        MemberResponse memberResponse = buildMemberResponse(newMember);

        return memberResponse;
    }

    @Override
    public MemberResponse read(Long id) {

        Member member = memberRepository.findById(id).get();

        MemberResponse memberResponse = buildMemberResponse(member);

        return memberResponse;
    }

    @Override
    @Transactional
    public MemberResponse update(Long id, MemberRequest request) {

        Member member = memberRepository.findById(id).get();

        member.setMemberName(request.getMemberName());
        member.setNickName(request.getNickName());
        member.setPassword(request.getPassword());

        Member changedMember = memberRepository.save(member);

        MemberResponse memberResponse = buildMemberResponse(changedMember);
        //System.out.println(changedMember.getMemberName());

        return memberResponse;
    }

    @Override
    @Transactional
    public Long delete(Long id) {

        try {
            memberRepository.deleteById(id);
            return id;
        } catch (Exception e) {
            return 0l;
        }
    }

    // <------------- memberResponse 빌드 ------------>
    private MemberResponse buildMemberResponse(Member member) {
        MemberResponse memberResponse = MemberResponse.builder()
                .memberName(member.getMemberName())
                .nickName(member.getNickName())
                .build();

        return memberResponse;
    }
}
