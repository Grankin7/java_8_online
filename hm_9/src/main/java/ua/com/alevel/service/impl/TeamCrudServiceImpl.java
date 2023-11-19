package ua.com.alevel.service.impl;

import ua.com.alevel.entity.Team;
import ua.com.alevel.service.TeamCrudService;
import ua.com.alevel.dao.impl.JsonBuilderTeamDao;

import java.util.Collection;
import java.util.Optional;

public class TeamCrudServiceImpl implements TeamCrudService {

    private BuilderCrudServiceImpl builderTeamImpl = new BuilderCrudServiceImpl();
    private JsonBuilderTeamDao builderTeamDao = new JsonBuilderTeamDao();
    @Override
    public void create(String teamName, String[] builderIds) {
        Team newTeam = new Team(teamName , builderIds);

        builderTeamDao.create(newTeam);
    }

    @Override
    public void update(Team team) {
        if (!builderTeamDao.existsById(team.getId())) {
            throw new RuntimeException("Builder not found");
        }
        builderTeamDao.update(team);
    }

    @Override
    public void delete(String id) {
        if (!builderTeamDao.existsById(id)) {
            throw new RuntimeException("Builder not found");
        }
        builderTeamDao.delete(id);
    }

    @Override
    public void deleteBuilder(String teamId, String builderId) {
        builderTeamDao.deleteBuilder(teamId, builderId);
    }

    @Override
    public Team findOne(String id) {
        Optional<Team> optionalTeam = builderTeamDao.findOne(id);
        if(optionalTeam.isEmpty()) {
            throw new RuntimeException("Team not found");
        }
        return optionalTeam.get();
    }

    @Override
    public Collection<Team> findAll() {
        return builderTeamDao.findAll();
    }
}
