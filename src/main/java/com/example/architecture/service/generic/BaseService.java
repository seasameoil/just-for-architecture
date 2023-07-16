package com.example.architecture.service.generic;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseService<T extends BaseEntity, Rq, Rs , R extends JpaRepository<T, Long>> {

    List<Rs> findAll() throws Exception;
    Rs save(Rq request) throws Exception;
    void delete(Long id) throws Exception;
    Rs update(Rq request, Long id) throws Exception;
}
