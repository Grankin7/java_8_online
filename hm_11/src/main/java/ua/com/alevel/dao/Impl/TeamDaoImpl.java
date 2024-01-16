package ua.com.alevel.dao.Impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.alevel.config.HibernateConfig;
import ua.com.alevel.dao.TeamDao;
import ua.com.alevel.entity.Builder;
import ua.com.alevel.entity.Team;
import java.util.*;


public class TeamDaoImpl implements TeamDao {

    private final SessionFactory sessionFactory = HibernateConfig.getInstance().getSessionFactory();

    @Override
    public void create(Team entity) {
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
    public void update(Team entity) {
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
            Team team = session.get(Team.class, id);
            session.delete(team);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public Optional<Team> findById(Long id) {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Team team = session.get(Team.class, id);
            transaction.commit();
            return Optional.of(team);
        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return Optional.empty();
    }

    @Override
    public Collection<Team> findAll() {
        Transaction transaction = null;
        try(Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("select teams from Team teams");
            List<Team> teams = query.getResultList();
            transaction.commit();
            return teams;

        } catch (Exception e){
            if(transaction != null) {
                transaction.rollback();
            }
        }

        return Collections.emptyList();
    }

    @Override
    public void attachBuilderToTeam(Long teamId, Long builderId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();

            Team team = session.get(Team.class, teamId);
            Builder builder = session.get(Builder.class, builderId);

            if (team != null && builder != null) {
                Set<Builder> builders = team.getBuilders();
                builders.add(builder);
                team.setBuilders(builders);

                Set<Team> teams = builder.getTeams();
                teams.add(team);
                builder.setTeams(teams);

                session.saveOrUpdate(team);
                session.saveOrUpdate(builder);

                transaction.commit();
            } else {
                System.out.println("Team or Builder not found");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


}
