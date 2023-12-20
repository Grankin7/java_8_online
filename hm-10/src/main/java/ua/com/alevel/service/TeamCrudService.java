package ua.com.alevel.service;

import ua.com.alevel.entity.Team;

import java.util.Collection;

public interface TeamCrudService{
    void create(String teamName, String[] builderIds);
    void update(Team be);
    void delete(String id);
    void deleteBuilder(String teamId, String builderId);
    Team findOne(String id);
    Collection<Team> findAll();
}
