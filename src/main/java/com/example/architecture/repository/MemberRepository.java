package com.example.architecture.repository;

import com.example.architecture.model.entity.Member;
import com.example.architecture.model.request.repository.MemberCondition;
import com.example.architecture.model.response.MemberResponse;
import com.example.architecture.repository.generic.BaseRepository;
import com.example.architecture.repository.generic.CustomRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends BaseRepository<Member>, CustomRepository<MemberCondition, MemberResponse> {
    Optional<Member> findByNickName(String username);
}
