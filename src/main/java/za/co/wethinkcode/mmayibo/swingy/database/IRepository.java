package za.co.wethinkcode.mmayibo.swingy.database;

import java.util.ArrayList;

public interface IRepository<T> {
    ArrayList<T> getALL();
    T getByID(int id);
    void create(T entity);
    boolean delete(T entity);
    void update(T entity);
}