package ua.com.alevel.dao.impl;

import com.google.gson.Gson;
import ua.com.alevel.dao.BuilderTeamDao;
import ua.com.alevel.entity.Team;
import ua.com.alevel.util.DbuUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonBuilderTeamDao implements BuilderTeamDao {

    List<Team> teamList = new ArrayList<>();

    @Override
    public void create(Team team) {
        readJson();
//        team.setId(DbuUtil.generateId(teamList));
        teamList.add(team);
        writeJson();
    }

    @Override
    public void update(Team team) {
        readJson();
        int index = -1;
        for (int i = 0; i < teamList.size(); i++) {
            if(teamList.get(i).getId().equals(team.getId())) {
                index = i;
            }
        }
        if(index != -1) {
            teamList.set(index, team);
        }
        writeJson();
    }

    @Override
    public void delete(String id) {
        readJson();
        teamList.removeIf(team -> team.getId().equals(id));
        writeJson();
    }

    public void deleteBuilder(String teamId, String builderId) {
        readJson();
        teamList = teamList.stream().map((team) -> {

            if(team.getId().equals(teamId)){
                System.out.println("found");
                team.setBuilderIds( Arrays.stream(team.getBuilderIds()).filter(id -> !Objects.equals(id, builderId)).toArray(String[]::new));
            }
            return team;
        }).toList();
        writeJson();
    }

    @Override
    public Optional<Team> findOne(String id) {
        readJson();
        return teamList.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public boolean existsById(String id) {
        readJson();
        return teamList.stream().anyMatch(builder -> builder.getId().equals(id));
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
