package ua.com.alevel.dao.impl;

import com.google.gson.Gson;
import ua.com.alevel.dao.BuilderTeamDao;
import ua.com.alevel.entity.Builder;
import ua.com.alevel.entity.Team;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JsonBuilderTeamDao implements BuilderTeamDao {

    List<Team> teamList = new ArrayList<>();

    @Override
    public void create(Team team) {

    }

    @Override
    public void update(Team team) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Collection<Team> findAll() {
        readJson();
        return this.teamList;
    }

    private void readJson() {
        Gson gson = new Gson();
        try {
            Team[] from = gson.fromJson(new FileReader("teamBuilders.json"), Team[].class);
            if (from != null) {
                this.teamList = new ArrayList<>();
                this.teamList.addAll(Arrays.asList(from));
            }
        } catch (FileNotFoundException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void writeJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this.teamList);
        try (FileWriter fileWriter = new FileWriter("teamBuilders.json")) {
            fileWriter.write(json);
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}
