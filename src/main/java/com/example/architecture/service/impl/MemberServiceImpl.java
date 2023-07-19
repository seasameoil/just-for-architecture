package com.example.architecture.service.impl;

import com.example.architecture.jwt.JwtTokenProvider;
import com.example.architecture.model.entity.Member;
import com.example.architecture.model.request.LoginRequest;
import com.example.architecture.model.request.MemberRequest;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.service.MemberService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member, MemberRequest, MemberResponse, MemberRepository> implements MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    public MemberServiceImpl(MemberRepository repository, JwtTokenProvider jwtTokenProvider) {
        super(repository);
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public MemberResponse save(MemberRequest request) throws Exception {
        try {
            String newPwd = passwordEncoder.encode(request.getPassword());
            request.setPassword(newPwd);

            Member entity = modelMapper.map(request, Member.class);
            memberRepository.save(entity);
            return modelMapper.map(entity, MemberResponse.class);
        } catch (Exception e){
            throw e;
        }
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

    @Transactional
    public String login(LoginRequest loginRequest) {

        Member findMember = memberRepository.findByNickName(loginRequest.getNickName())
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(loginRequest.getPassword(), findMember.getPassword())) {

            // Exception 추가 필요
            return null;
        }

        return jwtTokenProvider.createToken(findMember.getNickName(), findMember.getRoles());
    }
}
