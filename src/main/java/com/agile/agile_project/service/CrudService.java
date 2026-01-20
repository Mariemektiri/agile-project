package com.agile.agile_project.service;

import java.util.List;

public interface CrudService<T, ID> {
    T save(T entity);
    T getById(ID id);
    List<T> getAll();
    void delete(ID id);
}
