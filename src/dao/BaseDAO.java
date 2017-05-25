package dao;

import java.util.List;

/**
 * Created by Joakim on 25/05/2017.
 */
public interface BaseDAO<T> {

    public List<T> get();

    public void update(T element);

    public void insert(T element);

    public void delete(T element);

}
