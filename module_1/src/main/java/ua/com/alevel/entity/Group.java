package ua.com.alevel.entity;

public class Group {
    private String nameGroup;
    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Group(String nameGroup, Builders[] builders){
        nameGroup = nameGroup;
        builders = builders;
    }

    Builders[] builders = null;
    public void addBuilders(Builders[] buildersArray) {
        if (builders == null) {builders = buildersArray;}
    }
}
