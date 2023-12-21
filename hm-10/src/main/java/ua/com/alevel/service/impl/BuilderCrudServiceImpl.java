package ua.com.alevel.service.impl;

import ua.com.alevel.dao.BuilderDao;
import ua.com.alevel.dao.Impl.BuilderDaoImpl;
import ua.com.alevel.entity.Builder;
import ua.com.alevel.service.BuilderCrudService;

import java.util.Collection;
import java.util.Optional;

public class BuilderCrudServiceImpl implements BuilderCrudService {

    BuilderDao builderDao = new BuilderDaoImpl();
    @Override
    public void create(Builder builder) {
        builderDao.create(builder);
    }

    @Override
    public void update(Builder builder) {
        builderDao.update(builder);
    }

    @Override
    public void delete(Long id) {
        builderDao.delete(id);
    }

    @Override
    public Builder findOne(Long id) {
        Optional<Builder> optionalBuilder = builderDao.findById(id);
        return optionalBuilder.get();
    }

    @Override
    public Collection<Builder> findAll() {
        return builderDao.findAll();
    }
}
