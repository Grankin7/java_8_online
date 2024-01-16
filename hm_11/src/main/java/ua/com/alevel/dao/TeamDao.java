package ua.com.alevel.dao;

import ua.com.alevel.entity.Team;

public interface TeamDao extends CrudDao<Team> {

    void attachBuilderToTeam(Long temId, Long buildId);
}
