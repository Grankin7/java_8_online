package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.BankAccountDao;
import ua.com.alevel.entity.BankAccount;
import ua.com.alevel.entity.Operation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BankAccountDaoImpl implements BankAccountDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(BankAccount bankAccount) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(bankAccount);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(BankAccount bankAccount) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(bankAccount);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            BankAccount bankAccount = session.get(BankAccount.class, id);
            session.delete(bankAccount);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Optional<BankAccount> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            BankAccount bankAccount = session.get(BankAccount.class, id);
            transaction.commit();
            return Optional.of(bankAccount);
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return Optional.empty();
    }

//    public Optional<BankAccount> findById(Long userId) {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.getCurrentSession()) {
//            transaction = session.beginTransaction();
//            Query query = session.createQuery("FROM BankAccount WHERE user_id = :userId", BankAccount.class);
//            query.setParameter("userId", userId);
//            query.setMaxResults(1);
//            List<BankAccount> bankAccounts = query.getResultList();
//            transaction.commit();
//
//            if (!bankAccounts.isEmpty()) {
//                return Optional.of(bankAccounts.get(0));
//            } else {
//                return Optional.empty();
//            }
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            return Optional.empty();
//        }
//    }

    @Override
    public Collection<BankAccount> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("select bankAccounts from BankAccount bankAccounts");
            List<BankAccount> bankAccounts = query.getResultList();
            transaction.commit();
            return bankAccounts;
        } catch (Exception e) {
            System.out.println("e = " + e);
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return Collections.emptyList();
    }

}
