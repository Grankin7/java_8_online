package ua.com.alevel.service;

import ua.com.alevel.entity.Team;

public interface TeamCrudService extends CrudService<Team> {
    void attachBuilderToTeam(Long depId, Long empId);

}
