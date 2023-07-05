package com.example.architecture.repository;

import com.example.architecture.model.entity.Member;
import com.example.architecture.repository.generic.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends BaseRepository<Member> {
}
