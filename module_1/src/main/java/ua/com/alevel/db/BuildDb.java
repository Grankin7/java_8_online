package ua.com.alevel.db;
import ua.com.alevel.entity.Builders;
import ua.com.alevel.entity.Group;

import java.util.Locale;

public class BuildDb {
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

    private static Group[] groups = new Group[10];

    public void creatTeam(Builders builder) {
        for (int i = 0; i < builds.length; i++) {
            if (builds[i] == null) {
                builds[i] = builder;
                break;
            }
        }
    }
}
