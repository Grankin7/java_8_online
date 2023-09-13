package ua.com.alevel.service;

import ua.com.alevel.db.BuildDb;
import ua.com.alevel.entity.Builders;

public class BuildsService {
    private static BuildDb buildDb = new BuildDb();
    public static void create(String firstname, String lastname, String specialization, int yearsOfExperience) {
        Builders builder = new Builders();
        builder.setFirstname(firstname);
        builder.setLastname(lastname);
        builder.setSpecialization(specialization);
        builder.setYearsOfExperience(yearsOfExperience);
        buildDb.create(builder);
    }

    public static void createTeam(String nameTeam) {

    }

    public Builders[] findAll() {
        return buildDb.findAll();
    }

}
