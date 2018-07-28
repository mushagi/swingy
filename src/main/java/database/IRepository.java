package database;

import java.util.Collection;

public interface IRepository<T> {
    Collection<T> getALL();
    T getByID(int id);
    void create(T entity);
    boolean delete(T entity);
    void update(T entity);
}