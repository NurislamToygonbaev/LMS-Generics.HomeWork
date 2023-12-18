package java12.dao.impl;

import java12.dao.GenericDao;
import java12.db.DataBase;
import java12.model.Person;

import java.util.List;

public class PersonDaoImpl implements GenericDao<Person, Long> {

    private final DataBase dataBase;


    public PersonDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public boolean save(Person person) {
        return dataBase.add(person);
    }

    @Override
    public List<Person> getAll() {
        return dataBase.personList();
    }

    @Override
    public boolean remove(Long aLong) {
        return dataBase.remove(aLong);
    }

    @Override
    public Person getById(Long aLong) {
        for (Person person : dataBase.personList()) {
            if (aLong.equals(person.getId())){
                return person;
            }
        }
        throw new RuntimeException("Incorrect Id!");
    }
}
