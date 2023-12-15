package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.entity.Product;
import ua.com.alevel.factory.JdbcFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static java.util.stream.DoubleStream.generate;

public class ProductDaoImpl implements ProductDao {

    private final JdbcFactory jdbcFactory = JdbcFactory.getInstance();

    private static final String CREATE_PRODUCT = "INSERT INTO products (productName, productQuantity, productPrice) VALUES (?, ?, ?)";
    private static final String UPDATE_PRODUCT = "update products set productName = ?, productQuantity = ?,  productPrice = ? where id = ?";
    private static final String DELETE_PRODUCT = "delete from products where id = ?";
    private static final String FIND_PRODUCT = "select * from products where id = ";
    private static final String FIND_ALL_PRODUCT = "SELECT * FROM products";
//    private static final String FIND_ALL_EMPLOYEE_BY_DEPARTMENT = "select id, first_name, last_name, age from products as e left join dep_emp as de on e.id = de.emp_id where de.dep_id = ?";

    @Override
    public void create(Product product) {
        try {
            Connection connection = jdbcFactory.getConnection();
            if (connection != null) {
                try (PreparedStatement ps = connection.prepareStatement(CREATE_PRODUCT)) {
                    ps.setString(1, product.getProductName());
                    ps.setInt(2, product.getProductQuantity());
                    ps.setInt(3, product.getProductPrice());
                    ps.executeUpdate();
                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }


    @Override
    public void update(Product product) {
        try (PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(UPDATE_PRODUCT)) {
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getProductQuantity());
            ps.setInt(3, product.getProductPrice());
            ps.setLong(4, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement ps = jdbcFactory.getConnection().prepareStatement(DELETE_PRODUCT)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Product> findById(Long id) {
        try (ResultSet rs = jdbcFactory.getStatement().executeQuery(FIND_PRODUCT + id)) {
            rs.next();
            return Optional.of(generateProductByResultSet(rs));
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Collection<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try(ResultSet resultSet = jdbcFactory.getStatement().executeQuery("SELECT * FROM products")) {
            while(resultSet.next()) {
                products.add(generateProductByResultSet(resultSet));
            }
            return products;
        } catch (SQLException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
        return Collections.emptyList();
    }


    public Product generateProductByResultSet(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        Long id = resultSet.getLong("id");
        String productName = resultSet.getString("productName");
        int productQuantity = resultSet.getInt("productQuantity");
        int productPrice = resultSet.getInt("productPrice");
        product.setId(id);
        product.setProductName(productName);
        product.setProductQuantity(productQuantity);
        product.setProductPrice(productPrice);
        return product;
    }
}
