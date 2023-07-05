package com.example.architecture.controller.generic;

import com.example.architecture.model.entity.baseEntity.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;

public interface BaseController<T extends BaseEntity> {

    ResponseEntity<Object> save(@RequestPart(name = "data") T entity);
    ResponseEntity<T> findAll();
    ResponseEntity<String> delete(@PathVariable Long id);
}
