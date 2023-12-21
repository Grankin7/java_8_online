package ua.com.alevel.service.impl;

import ua.com.alevel.dao.BuilderDao;
import ua.com.alevel.dao.Impl.BuilderDaoImpl;
import ua.com.alevel.dao.Impl.TeamDaoImpl;
import ua.com.alevel.dao.TeamDao;
import ua.com.alevel.entity.Builder;
import ua.com.alevel.entity.Team;
import ua.com.alevel.service.TeamCrudService;

import java.util.Collection;
import java.util.Optional;

public class TeamCrudServiceImpl implements TeamCrudService {

    BuilderDao builderDao = new BuilderDaoImpl();
    TeamDao teamDao = new TeamDaoImpl();

    @Override
    public void create(Team team) {
        teamDao.create(team);
    }

    @Override
    public void update(Team team) {
        teamDao.update(team);
    }

    @Override
    public void delete(Long id) {
        teamDao.delete(id);
    }

    @Override
    public Team findOne(Long id) {
        Optional<Team> optionalBuilder = teamDao.findById(id);
        return optionalBuilder.get();
    }

    @Override
    public Collection<Team> findAll() {
        return teamDao.findAll();
    }

    public void attachBuilderToTeam(Long idT, Long idB) {
        teamDao.attachBuilderToTeam(idT,idB);
    }


}
