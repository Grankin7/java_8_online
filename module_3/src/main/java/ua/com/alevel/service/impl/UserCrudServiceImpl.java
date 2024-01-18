package ua.com.alevel.service.impl;

import ua.com.alevel.dao.UserDao;
import ua.com.alevel.dao.impl.UserDaoImpl;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.UserCrudService;

import java.util.Collection;
import java.util.Optional;

public class UserCrudServiceImpl implements UserCrudService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public User findOne(Long id) {
        Optional<User> optionalUser = userDao.findById(id);
        return optionalUser.get();
    }

    @Override
    public Collection<User> findAll() {
        return userDao.findAll();
    }
}
