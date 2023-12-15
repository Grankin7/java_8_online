package ua.com.alevel.service.impl;

import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.dao.impl.ProductDaoImpl;
import ua.com.alevel.entity.Product;
import ua.com.alevel.service.ProductCrudService;

import java.util.Collection;
import java.util.Optional;

public class ProductCrudServiceImpl implements ProductCrudService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public void create(Product product) {
        productDao.create(product);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delete(Long id) {
        productDao.delete(id);
    }

    @Override
    public Product findOne(Long id) {
        Optional<Product> optionalProduct = productDao.findById(id);
        return optionalProduct.get();
    }

    @Override
    public Collection<Product> findAll() {
        return productDao.findAll();
    }
}
