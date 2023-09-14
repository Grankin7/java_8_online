package ua.com.alevel.service;

import ua.com.alevel.db.DataBase;
import ua.com.alevel.entity.Builders;
import ua.com.alevel.entity.Group;

public class BuildsService {
    private static DataBase dataBase = new DataBase();
    public void create(String firstname, String lastname, String specialization, int yearsOfExperience, int id) {
        Builders builder = new Builders();
        builder.setFirstname(firstname);
        builder.setLastname(lastname);
        builder.setSpecialization(specialization);
        builder.setYearsOfExperience(yearsOfExperience);
        builder.setId(id);
        dataBase.create(builder);
    }


    public void createTeam(String nameTeam) {
        Group group = new Group();
        group.setNameGroup(nameTeam);
        dataBase.creatTeam(group);
    }

    public Builders[] findAll() {
        return dataBase.findAll();
    }

    public void delete(int id){

    }

}
