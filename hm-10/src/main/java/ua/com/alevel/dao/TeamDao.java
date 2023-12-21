package ua.com.alevel.dao;

import ua.com.alevel.entity.Team;

import java.util.Collection;
import java.util.Optional;

public interface TeamDao extends CrudDao<Team> {

    void attachBuilderToTeam(Long temId, Long buildId);
}
