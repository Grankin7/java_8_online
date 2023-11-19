package ua.com.alevel.service;

import ua.com.alevel.entity.Builder;

import java.util.Collection;

public interface BuilderCrudService {
    void create(Builder be);
    void update(Builder be);
    void delete(String id);
    Builder findOne(String id);
    Collection<Builder> findAll();
    Builder[] findByIds(String[] ids);
}
