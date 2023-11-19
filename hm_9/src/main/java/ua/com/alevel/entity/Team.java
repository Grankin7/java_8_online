package ua.com.alevel.entity;

public class Team extends BaseEntity {

    String nameTeam;
    String[] builderIds;

    public String[] getBuilderIds() {
        return builderIds;
    }

    public void setBuilderIds(String[] builderIds) {
        this.builderIds = builderIds;
    }

    public Team(String teamName , String[] builders){
        this.nameTeam = teamName;
        this.builderIds = builders;
    }

    public Team(){

    }


    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

}
