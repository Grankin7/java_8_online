package ua.com.alevel.service.impl;

import ua.com.alevel.dao.BankAccountDao;
import ua.com.alevel.dao.impl.BankAccountDaoImpl;
import ua.com.alevel.entity.BankAccount;
import ua.com.alevel.entity.User;
import ua.com.alevel.service.BankAccountCrudService;

import java.util.Collection;
import java.util.Optional;

public class BankAccountCrudServiceImpl implements BankAccountCrudService {

    BankAccountDao bankAccountDao = new BankAccountDaoImpl();
    @Override
    public void create(BankAccount bankAccount) {
        bankAccountDao.create(bankAccount);
    }

    @Override
    public void update(BankAccount bankAccount) {
        bankAccountDao.update(bankAccount);
    }

    @Override
    public void delete(Long id) {
        bankAccountDao.delete(id);
    }

    @Override
    public BankAccount findOne(Long id) {
        Optional<BankAccount> optionalBankAccount = bankAccountDao.findById(id);
        return optionalBankAccount.get();
    }

    @Override
    public Collection<BankAccount> findAll() {
        return bankAccountDao.findAll();
    }
}
