package ru.job4j.tracker.store;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 09.03.2023
 * @project: job4j_tracker
 */
public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
    private final SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        var session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        var session = sf.openSession();
        boolean rsl = false;
        try {
            session.beginTransaction();
            var query = session.createQuery(
                    "UPDATE Item SET name = :fName, created = :fCreated WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate();
            if (query > 0) {
                rsl = true;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        var session = sf.openSession();
        boolean rsl = false;
        try {
            session.beginTransaction();
            var query = session.createQuery("DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            if (query > 0) {
                rsl = true;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        var session = sf.openSession();
        List<Item> list = new ArrayList<>();
        try {
            session.beginTransaction();
            var query = session.createQuery("SELECT i FROM Item i ORDER BY i.id ASC", Item.class);
            list = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        var session = sf.openSession();
        List<Item> list = new ArrayList<>();
        try {
            session.beginTransaction();
            var query = session.createQuery("SELECT i FROM Item i WHERE i.name = :fName", Item.class)
                    .setParameter("fName", key);
            list = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        var session = sf.openSession();
        Item item = null;
        try {
            session.beginTransaction();
            item = session.createQuery("SELECT i FROM Item i WHERE i.id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
