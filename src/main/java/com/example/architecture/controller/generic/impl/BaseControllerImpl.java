package com.example.architecture.controller.generic.impl;

import com.example.architecture.controller.generic.BaseController;
import com.example.architecture.model.entity.baseEntity.BaseEntity;
import com.example.architecture.service.generic.BaseService;
import com.example.architecture.service.generic.impl.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"unchecked", "rawtypes"})
@ResponseBody
@RequiredArgsConstructor
public class BaseControllerImpl<T extends BaseEntity, R extends JpaRepository<T, Long>> implements BaseController<T> {
    private final BaseService<T,R> baseService;

    @Override
    @PostMapping
    public ResponseEntity<Object> save(T entity) {
        try {
            return new ResponseEntity(baseService.save(entity), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<T> findAll() {

        try {
            return new ResponseEntity(baseService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            baseService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}