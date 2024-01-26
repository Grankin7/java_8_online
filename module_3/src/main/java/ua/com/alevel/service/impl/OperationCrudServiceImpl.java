package ua.com.alevel.service.impl;

import ua.com.alevel.dao.OperationDao;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.dao.impl.OperationDaoImpl;
import ua.com.alevel.dao.impl.UserDaoImpl;
import ua.com.alevel.entity.Operation;
import ua.com.alevel.service.OperationCrudService;

import java.util.Collection;
import java.util.Optional;

public class OperationCrudServiceImpl implements OperationCrudService {

    OperationDao operationDao = new OperationDaoImpl();

    @Override
    public void create(Operation operation) {
        operationDao.create(operation);
    }

    @Override
    public void update(Operation operation) {
        operationDao.update(operation);
    }

    @Override
    public void delete(Long id) {
        operationDao.delete(id);
    }

    @Override
    public Operation findOne(Long id) {
        Optional<Operation> optionalOperation = operationDao.findById(id);
        return optionalOperation.get();
    }

    @Override
    public Collection<Operation> findAll() {
        return operationDao.findAll();
    }
}
