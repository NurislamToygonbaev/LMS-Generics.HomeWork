package java12.dao;

import java.util.List;

public interface GenericDao<T, ID> {

    boolean save(T t);

    List<T> getAll();

    boolean remove(ID id);

    T getById(ID id);
}
