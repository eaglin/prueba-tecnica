package com.mvabal.prueba_tecnica.shared.domain;

import java.util.List;

public interface CustomCrudRepository<T> {
    T save(T entity);

    T update(T entity);

    void delete(Long id);

}
