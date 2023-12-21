package ua.com.alevel.dao.Impl;

import ua.com.alevel.dao.TeamDao;
import ua.com.alevel.entity.Builder;
import ua.com.alevel.entity.Team;
import ua.com.alevel.factory.JdbcFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TeamDaoImpl implements TeamDao {

    private final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    private static final String CREATE_TEAMS = "insert into teams values (default, ?)";
    private static final String UPDATE_TEAMS = "UPDATE teams SET name = ? WHERE id = ?;";
    private static final String DELETE_TEAMS = "delete from teams where id = ?";
    private static final String DELETE_BUILD_TEAM = "DELETE FROM buid_team WHERE team_id = ?";
    private static final String FIND_TEAMS = "select * from teams where id = ";
    private static final String FIND_ALL_TEAMS = "SELECT * FROM teams";

    private static final String ATTACH_BUILDER_TO_TEAM = "insert into buid_team values (?, ?)";

    @Override
     public void create(Team entity) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(CREATE_TEAMS)) {
            ps.setString(1, entity.getNameTeam());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Team entity) {
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(UPDATE_TEAMS)) {
            ps.setString(1, entity.getNameTeam());
            ps.setLong(2, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(DELETE_TEAMS)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Team> findById(Long id) {
        try (ResultSet rs = jdbcFactory.getStatement().executeQuery(FIND_TEAMS + id)) {
            rs.next();
            return Optional.of(generateTeamsByResultSet(rs));
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Collection<Team> findAll() {
        List<Team> teams = new ArrayList<>();
        try(ResultSet resultSet = jdbcFactory.getStatement().executeQuery(FIND_ALL_TEAMS)) {
            while(resultSet.next()) {
                teams.add(generateTeamsByResultSet(resultSet));
            }
            return teams;
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public void attachBuilderToTeam(Long buildId, Long teamId) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(ATTACH_BUILDER_TO_TEAM)) {
            ps.setLong(1, buildId);
            ps.setLong(2, teamId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Team generateTeamsByResultSet(ResultSet resultSet) throws SQLException {
        Team team = new Team();
        Long id = resultSet.getLong("id");
        String builderName = resultSet.getString("name");
        team.setId(id);
        team.setNameTeam(builderName);
        return team;
    }
}
