package com.example.architecture.repository;

import com.example.architecture.model.entity.Member;
import com.example.architecture.repository.generic.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends BaseRepository<Member> {
    Optional<Member> findByNickName(String username);
}
