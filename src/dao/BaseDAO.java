package dao;

import java.util.List;


///////////////////////////////////////// Joakim //////////////////////////////////////

public interface BaseDAO<T> {

    public List<T> get();

    public void update(T element);

    public void insert(T element);

    public void delete(T element);

}
