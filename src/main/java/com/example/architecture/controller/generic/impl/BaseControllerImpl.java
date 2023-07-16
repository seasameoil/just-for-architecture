package com.example.architecture.controller.generic.impl;

import com.example.architecture.controller.generic.BaseController;
import com.example.architecture.model.entity.baseEntity.BaseEntity;
import com.example.architecture.service.generic.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings({"unchecked", "rawtypes"})
@ResponseBody
@RequiredArgsConstructor
public class BaseControllerImpl<T extends BaseEntity, Rq, Rs, R extends JpaRepository<T, Long>> implements BaseController<Rq, Rs> {
    private final BaseService<T, Rq, Rs, R> baseService;

    @Override
    @PostMapping
    public ResponseEntity<Object> save(Rq request) {
        try {
            return new ResponseEntity(baseService.save(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @GetMapping
    public ResponseEntity findAll() {

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

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Rs> update(Rq request, @PathVariable Long id) {

        try {
            Rs response = baseService.update(request, id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
