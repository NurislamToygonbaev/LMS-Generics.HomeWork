package java12.service;

import java.util.List;

public interface GenericService<T> {

    boolean add(T t);

    boolean add(List<T> t);

    T getById(Long id);

    List<T> getAll();

    List<T> sortByName(int i);

    List<T> filterByGender(int i);

    List<T> clear();
}
