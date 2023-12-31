package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface CrudDao<BE extends BaseEntity> {
    void create(BE be);
    void update(BE be);
    void delete(String id);
    boolean existsById(String id);
    Optional<BE> findById(String id);
    Collection<BE> findAll();

}
