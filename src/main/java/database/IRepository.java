package database;

import java.util.Collection;

public interface IRepository<T> {
    Collection<T> getALL();
    T getByID(int id);
    T create(T entity);
    T delete(T entity);
    T update(T entity);
}