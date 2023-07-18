package com.example.architecture.service.impl;

import com.example.architecture.jwt.JwtTokenProvider;
import com.example.architecture.jwt.TokenInfo;
import com.example.architecture.model.entity.Member;
import com.example.architecture.model.request.MemberRequest;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.MemberRepository;
import com.example.architecture.service.MemberService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl extends BaseServiceImpl<Member, MemberRequest, MemberResponse, MemberRepository> implements MemberService {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ModelMapper modelMapper;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    public MemberServiceImpl(MemberRepository repository, AuthenticationManagerBuilder authenticationManagerBuilder, JwtTokenProvider jwtTokenProvider) {
        super(repository);
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jwtTokenProvider = jwtTokenProvider;
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
    public TokenInfo login(String nickName, String password) {

        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nickName, password);

        // 2. 실제 검증 (사용자 비밀번호 체크)가 이루어지는 부분
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }
}
