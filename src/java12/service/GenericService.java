package java12.service;

import java.util.List;

public interface GenericService<T> {

    boolean add(T t);

    boolean add(List<T> t);

    T getById(Long id);

    List<T> getAll();

    List<T> sortByName();

    List<T> filterByGender();

    List<T> clear();
}
