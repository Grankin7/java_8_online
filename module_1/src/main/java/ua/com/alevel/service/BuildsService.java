package ua.com.alevel.service;

import ua.com.alevel.db.BuilderDb;
import ua.com.alevel.db.GroupBd;
import ua.com.alevel.entity.Builders;
import ua.com.alevel.entity.Group;

public class BuildsService {
    private BuilderDb dataBase = new BuilderDb();
    private GroupBd groupDb = new GroupBd();
    public void create(String firstname, String lastname, String specialization, int yearsOfExperience, int id) {
        Builders builder = new Builders();
        builder.setFirstname(firstname);
        builder.setLastname(lastname);
        builder.setSpecialization(specialization);
        builder.setYearsOfExperience(yearsOfExperience);
        builder.setId(id);
        dataBase.create(builder);
    }


    public void createTeam(int[] ids, String nameTeam) {
        Builders[] builders = dataBase.searchByIds(ids);
        groupDb.creatTeam(builders,nameTeam);

    }

    public Builders[] findAll() {
        return dataBase.findAll();
    }
    public Builders[] lockAllBuildersInTeam() {
        return dataBase.lockAllBuildersInTeam();
    }
    public Group[] lockAllGroup(){
        return groupDb.lockAllBuildersInTeam();
    }

    public void delete(int id){
        dataBase.delete(id);
    }

    public void deleteTeam(String teamRemote) {
        groupDb.deleteTeam(teamRemote);
    }

}
