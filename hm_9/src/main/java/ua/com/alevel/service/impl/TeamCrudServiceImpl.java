package ua.com.alevel.service.impl;

import ua.com.alevel.dao.BuilderTeamDao;
import ua.com.alevel.entity.Team;
import ua.com.alevel.service.TeamCrudService;
import ua.com.alevel.dao.impl.JsonBuilderTeamDao;

import java.util.Collection;

public class TeamCrudServiceImpl implements TeamCrudService {

    private BuilderTeamDao builderTeamDao = new JsonBuilderTeamDao();
    @Override
    public void create(Team team) {

    }

    @Override
    public void update(Team team) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Team findOne(String id) {
        return null;
    }

    @Override
    public Collection<Team> findAll() {
        return null;
    }
}
