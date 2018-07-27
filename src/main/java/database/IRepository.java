package database;

import java.util.Collection;

public interface IRepository<T> {
    Collection<T> getALL();
    T getByID(int id);
    boolean create(T entity);
    boolean delete(T entity);
    boolean update(T entity);
}