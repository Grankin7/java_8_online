package ua.com.alevel.dao.Impl;

import ua.com.alevel.dao.BuilderDao;
import ua.com.alevel.entity.Builder;
import ua.com.alevel.factory.JdbcFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class BuilderDaoImpl implements BuilderDao {

    private final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    private static final String CREATE_BUILDER = "insert into builders values (default, ?, ?, ?)";
    private static final String UPDATE_BUILDER = "UPDATE builders SET name = ?, speciality = ?, age = ? WHERE id = ?;";
    private static final String FIND_BUILDER = "select * from builders where id = ";
    private static final String FIND_ALL_BUILDER = "SELECT * FROM builders";

    @Override
    public void create(Builder entity) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(CREATE_BUILDER)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getSpeciality());
            ps.setInt(3, entity.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Builder entity) {
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(UPDATE_BUILDER)) {
            ps.setString(1, entity.getName() );
            ps.setString(2, entity.getSpeciality());
            ps.setInt(3, entity.getAge());
            ps.setLong(4, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement("delete from builders where id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Builder> findById(Long id) {
        try (ResultSet rs = jdbcFactory.getStatement().executeQuery(FIND_BUILDER + id)) {
            rs.next();
            return Optional.of(generateBuilderByResultSet(rs));
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return Optional.empty();
    }

    public Collection<Builder> findAll() {
        List<Builder> builders = new ArrayList<>();
        try(ResultSet resultSet = jdbcFactory.getStatement().executeQuery(FIND_ALL_BUILDER)) {
            while(resultSet.next()) {
                builders.add(generateBuilderByResultSet(resultSet));
            }
            return builders;
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return Collections.emptyList();
    }

    public Builder generateBuilderByResultSet(ResultSet resultSet) throws SQLException {
        Builder builder = new Builder();
        Long id = resultSet.getLong("id");
        String builderName = resultSet.getString("name");
        String builderSpeciality = resultSet.getString("speciality");
        int builderAge = resultSet.getInt("age");
        builder.setId(id);
        builder.setName(builderName);
        builder.setSpeciality(builderSpeciality);
        builder.setAge(builderAge);
        return builder;
    }
}
