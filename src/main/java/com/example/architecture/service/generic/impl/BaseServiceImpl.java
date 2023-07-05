package com.example.architecture.service.generic.impl;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import com.example.architecture.service.generic.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseEntity, R extends JpaRepository<T, Long>> implements BaseService<T, R> {

    private final R repository;

    @Override
    public List<T> findAll() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public T save(T entity) throws Exception {
        try {
            return repository.save(entity);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
