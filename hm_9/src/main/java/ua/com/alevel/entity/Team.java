package ua.com.alevel.entity;

public class Team extends BaseEntity {

    String nameTeam;
    String specialization;
    String idBuilders;

    public String getIdBuilders() {
        return idBuilders;
    }

    public void setIdBuilders(String idBuilders) {
        this.idBuilders = idBuilders;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
