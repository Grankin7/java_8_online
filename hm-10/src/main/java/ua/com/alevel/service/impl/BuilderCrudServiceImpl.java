package ua.com.alevel.service.impl;

import ua.com.alevel.dao.BuilderDao;
import ua.com.alevel.dao.impl.JsonBuilderDao;
import ua.com.alevel.entity.Builder;
import ua.com.alevel.service.BuilderCrudService;

import java.util.Collection;
import java.util.Optional;

public class BuilderCrudServiceImpl implements BuilderCrudService {

    private BuilderDao builderDao = new JsonBuilderDao();

    @Override
    public void create(Builder builder) {
        builderDao.create(builder);
    }


    @Override
    public void update(Builder builder) {
        if (!builderDao.existsById(builder.getId())) {
            throw new RuntimeException("Builder not found");
        }
        builderDao.update(builder);
    }

    @Override
    public void delete(String id) {
        if (!builderDao.existsById(id)) {
            throw new RuntimeException("Builder not found");
        }
        builderDao.delete(id);
    }

    @Override
    public Builder findOne(String id) {
        Optional<Builder> optionalBuilder = builderDao.findById(id);
        if(optionalBuilder.isEmpty()) {
            throw new RuntimeException("Builder not found");
        }
        return optionalBuilder.get();
    }

    @Override
    public Collection<Builder> findAll() {
        return builderDao.findAll();
    }

    @Override
    public Builder[] findByIds(String[] ids) {
        return builderDao.findByIds(ids);
    }
}
