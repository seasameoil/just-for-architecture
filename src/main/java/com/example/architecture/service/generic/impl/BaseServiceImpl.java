package com.example.architecture.service.generic.impl;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import com.example.architecture.service.generic.BaseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class BaseServiceImpl<T extends BaseEntity, Rq, Rs, R extends JpaRepository<T, Long>> implements BaseService<T, Rq, Rs, R> {

    @Autowired
    ModelMapper modelMapper;
    private final R repository;

    @Override
    public List<Rs> findAll() throws Exception {
        try {
            List<T> entities = repository.findAll();
            return entities.stream()
                    .map(entity -> modelMapper.map(entity, getResponseType()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Rs save(Rq request) throws Exception {
        try {
            T entity = modelMapper.map(request, getEntityType());
            repository.save(entity);
            return modelMapper.map(entity, getResponseType());
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

    @Override
    public Rs update(Rq request, Long id) throws Exception {
        try {

            T entity = modelMapper.map(request, getEntityType());
            Rs response = modelMapper.map(entity, getResponseType());
            return response;

        } catch (Exception e) {
            throw  e;
        }
    }

    // Helper method to get the entity type
    private Class<T> getEntityType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    // Helper method to get the response type
    private Class<Rs> getResponseType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<Rs>) parameterizedType.getActualTypeArguments()[2];
    }
}
