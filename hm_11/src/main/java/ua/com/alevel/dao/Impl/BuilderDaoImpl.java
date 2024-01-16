package ua.com.alevel.dao.Impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.BuilderDao;
import ua.com.alevel.entity.Builder;
import java.util.*;

public class BuilderDaoImpl implements BuilderDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Builder entity) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void update(Builder entity) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
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
            Builder builder = session.get(Builder.class, id);
            session.delete(builder);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<Builder> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Builder builder = session.get(Builder.class, id);
            transaction.commit();
            return Optional.of(builder);
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return Optional.empty();
    }

    @Override
    public Collection<Builder> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()){
            transaction = session.beginTransaction();
            Query query = session.createQuery("select builders from Builder builders");
            List<Builder> builders = query.getResultList();
            transaction.commit();
            return builders;
        } catch (Exception e) {
            System.out.println("e = " + e);
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return Collections.emptyList();
    }
}
