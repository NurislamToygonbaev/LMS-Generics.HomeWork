package java12.service.impl;

import java12.dao.impl.PersonDaoImpl;
import java12.model.Person;
import java12.service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {

    private final PersonDaoImpl personDao;

    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }

    @Override
    public boolean add(Person person) {
        return personDao.save(person);
    }

    @Override
    public boolean add(List<Person> t) {
        return personDao.getAll().addAll(t);
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName() {
        List<Person> list = new ArrayList<>(personDao.getAll());
        Comparator<Person> comparator = Comparator.comparing(Person::getName);
        list.sort(comparator);
        return list;
    }

    @Override
    public List<Person> filterByGender() {
        List<Person> list = new ArrayList<>(personDao.getAll());
        Comparator<Person> comparator = Comparator.comparing(Person::getGender);
        list.sort(comparator);
        return list;
    }

    @Override
    public List<Person> clear() {
        personDao.getAll().clear();
        return personDao.getAll();
    }
}
