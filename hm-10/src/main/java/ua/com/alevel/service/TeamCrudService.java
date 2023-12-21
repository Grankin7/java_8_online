package ua.com.alevel.service;

import ua.com.alevel.entity.Builder;
import ua.com.alevel.entity.Team;

import java.util.Collection;

public interface TeamCrudService extends CrudService<Team> {
    void attachBuilderToTeam(Long depId, Long empId);

}
