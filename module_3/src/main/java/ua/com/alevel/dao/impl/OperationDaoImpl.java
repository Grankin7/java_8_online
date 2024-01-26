package ua.com.alevel.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.OperationDao;
import ua.com.alevel.entity.BankAccount;
import ua.com.alevel.entity.Operation;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class OperationDaoImpl implements OperationDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();


    @Override
    public void create(Operation operation) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(operation);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(Operation operation) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(operation);
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
            Operation operation = session.get(Operation.class, id);
            session.delete(operation);
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
    public Optional<Operation> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Operation operation = session.get(Operation.class, id);
            transaction.commit();
            return Optional.of(operation);
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return Optional.empty();
    }

    @Override
    public Collection<Operation> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("select operations from Operation operations");
            List<Operation> operations = query.getResultList();
            transaction.commit();
            return operations;
        } catch (Exception e) {
            System.out.println("e = " + e);
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return Collections.emptyList();
    }

}
