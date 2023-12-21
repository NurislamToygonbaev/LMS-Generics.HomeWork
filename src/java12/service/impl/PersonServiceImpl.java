package java12.service.impl;

import java12.NotFoundException;
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
        try {
            return personDao.getById(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName(int i) {
        List<Person> list = new ArrayList<>(personDao.getAll());
        if (i == 1) {
            Comparator<Person> comparator = Comparator.comparing(Person::getName);
            list.sort(comparator);
            return list;
        } else if (i == 2) {
            Comparator<Person> comparator = Comparator.comparing(Person::getName).reversed();
            list.sort(comparator);
            return list;
        }
        throw new NotFoundException("write correct!!!");
    }

    @Override
    public List<Person> filterByGender(int i) {
        List<Person> list = new ArrayList<>();

        if (i == 1) {
            for (Person person : personDao.getAll()) {
                if ("female".equalsIgnoreCase(String.valueOf(person.getGender()))) {
                    list.add(person);
                }
            }
            return list;
        } else if (i == 2) {
            for (Person person : personDao.getAll()) {
                if ("male".equalsIgnoreCase(String.valueOf(person.getGender()))) {
                    list.add(person);
                }
            }
            return list;
        }
        throw new NotFoundException("write correct!!!");
    }

    @Override
    public List<Person> clear() {
        personDao.getAll().clear();
        return personDao.getAll();
    }
}
