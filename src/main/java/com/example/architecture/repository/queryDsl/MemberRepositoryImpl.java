package com.example.architecture.repository.queryDsl;

import com.example.architecture.model.request.repository.MemberCondition;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.generic.CustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements CustomRepository<MemberCondition, MemberResponse> {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberResponse> findBy(MemberCondition memberCondition) {
        return null; // 관련 쿼리 작성 필요
    }
}
