package dataaccess;

import java.util.List;


///////////////////////////////////////// Joakim //////////////////////////////////////

public interface BaseDAO<A> extends GetDAO<A> {

    public List<A> get();

    public void update(A element);

    public void insert(A element);

    public void delete(A element);

}
