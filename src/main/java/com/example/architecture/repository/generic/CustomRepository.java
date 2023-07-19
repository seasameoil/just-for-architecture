package com.example.architecture.repository.generic;

import java.util.List;

public interface CustomRepository<Rq, Rs> {
    List<Rs> findBy(Rq rq);
}
