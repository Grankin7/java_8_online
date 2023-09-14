package ua.com.alevel.db;
import ua.com.alevel.entity.Builders;
import ua.com.alevel.entity.Group;

public class DataBase {
    private Builders[] builds = new Builders[10];

    public void create(Builders builder) {
        for (int i = 0; i < builds.length; i++) {
            if (builds[i] == null) {
                builds[i] = builder;
                break;
            }
        }
    }

    public Builders[] findAll() {
        return builds;
    }

    private Group[] groups = new Group[10];

    public void creatTeam(Group gro) {
        for (int i = 0; i < builds.length; i++) {
            if (groups[i] == null) {
                groups[i] = gro;
                break;
            }
        }
    }

    public void delete(int id){
        for (int i = 0; i < builds.length; i++) {
        }
    }
}
