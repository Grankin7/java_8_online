package ua.com.alevel.dao.impl;

import com.google.gson.Gson;
import ua.com.alevel.dao.BuilderDao;
import ua.com.alevel.entity.Builder;
import ua.com.alevel.util.DbuUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonBuilderDao implements BuilderDao {
    List<Builder> builderList = new ArrayList<>();

    public void create(Builder builder) {
        readJson();
        builder.setId(DbuUtil.generateId(builderList));
        builderList.add(builder);
        writeJson();
    }

    @Override
    public void update(Builder builder) {
        readJson();
        int index = -1;
        for (int i = 0; i < builderList.size(); i++) {
            if(builderList.get(i).getId().equals(builder.getId())) {
                index = i;
            }
        }
        if(index != -1) {
            builderList.set(index, builder);
        }
        writeJson();
    }

    @Override
    public void delete(String id) {
        readJson();
        builderList.removeIf(builder -> builder.getId().equals(id));
        writeJson();
    }

    @Override
    public boolean existsById(String id) {
        readJson();
        return builderList.stream().anyMatch(builder -> builder.getId().equals(id));
    }

    @Override
    public Optional<Builder> findById(String id) {
        readJson();
        return builderList.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    @Override
    public Collection<Builder> findAll() {
        readJson();
        return this.builderList;
    }

    private void readJson() {
        Gson gson = new Gson();
        try {
            Builder[] from = gson.fromJson(new FileReader("builder.json"), Builder[].class);
            if (from != null) {
                this.builderList = new ArrayList<>();
                this.builderList.addAll(Arrays.asList(from));
            }
        } catch (FileNotFoundException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void writeJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this.builderList);
        try (FileWriter fileWriter = new FileWriter("builder.json")) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        } ;
    }
}
