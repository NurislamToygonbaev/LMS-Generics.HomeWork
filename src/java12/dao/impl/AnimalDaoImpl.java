package java12.dao.impl;

import java12.dao.GenericDao;
import java12.db.DataBase;
import java12.model.Animal;

import java.util.List;

public class AnimalDaoImpl implements GenericDao<Animal, Long> {

    private final DataBase dataBase;

    public AnimalDaoImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public boolean save(Animal animal) {
        return dataBase.add(animal);
    }

    @Override
    public List<Animal> getAll() {
        return dataBase.animalList();
    }

    @Override
    public boolean remove(Long aLong) {
        return dataBase.remove(aLong);
    }

    @Override
    public Animal getById(Long aLong) {
        for (Animal animal : dataBase.animalList()) {
            if (aLong.equals(animal.getId())){
                return animal;
            }
        }
        throw new RuntimeException("Incorrect Id!");
    }
}
