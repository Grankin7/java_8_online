package ua.com.alevel.db;
import ua.com.alevel.entity.Builders;
import ua.com.alevel.entity.Group;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BuilderDb {
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

    public void delete(int id){
        for (int i = 0; i < builds.length; i++) {
            if(id == builds[i].getId()) {
                builds[i] = null;
                break;
            }
        }
    }
    public Builders[] searchByIds(int[] ids){
        Builders[] response = new Builders[ids.length];
        for (int i = 0, j = 0; i < builds.length ; i++) {
            if(builds[i] != null && Arrays.asList(ids).contains(builds[i].getId())) {
                response[j] = builds[i];
                j++;
            }
        }
        return response;
    }

}
