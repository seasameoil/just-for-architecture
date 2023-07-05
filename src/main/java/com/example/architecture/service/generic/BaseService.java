package com.example.architecture.service.generic;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseService<T extends BaseEntity, R extends JpaRepository<T, Long>> {

    List<T> findAll() throws Exception;
    T save(T entity) throws Exception;
    void delete(Long id) throws Exception;
}
