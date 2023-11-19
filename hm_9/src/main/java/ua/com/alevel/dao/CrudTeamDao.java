package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Team;

import java.util.Collection;
import java.util.Optional;

public interface CrudTeamDao <BE extends BaseEntity> {

    void create(BE be);
    void update(BE be);
    void delete(String id);
    Optional<Team> findOne(String name);
    Collection<BE> findAll();
}
