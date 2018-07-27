package database;

import models.players.Hero;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

public class RepositoryImpl implements IRepository<Hero> {
    Session session = HibernateUtil.getInstance().getSession();

    @Override
    public Collection<Hero> getALL() {
        Collection<Hero> heroes = null;
        try {
            Transaction transaction = session.beginTransaction();
            heroes = session.createCriteria(Hero.class).list();
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return heroes;
    }

    @Override
    public Hero getByID(int id) {
        Hero hero = null;
        try {
            Transaction transaction = session.beginTransaction();
            hero = session.get(Hero.class, id);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return hero;
    }

    @Override
    public boolean create(Hero entity) {
        try {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Hero entity) {
        try {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Hero entity) {
        try {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
