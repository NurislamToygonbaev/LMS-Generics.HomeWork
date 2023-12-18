package java12.service.impl;

import java12.dao.impl.AnimalDaoImpl;
import java12.model.Animal;
import java12.service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class AnimalServiceImpl implements GenericService<Animal> {

    private final AnimalDaoImpl animalDao;

    public AnimalServiceImpl(AnimalDaoImpl animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public boolean add(Animal animal) {
        return animalDao.save(animal);
    }

    @Override
    public boolean add(List<Animal> t) {
        return animalDao.getAll().addAll(t);
    }

    @Override
    public Animal getById(Long id) {
        return animalDao.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName() {
        List<Animal> animals = new ArrayList<>(animalDao.getAll());
        Comparator<Animal> comparator = Comparator.comparing(Animal::getName);
        animals.sort(comparator);
        return animals;
    }

    @Override
    public List<Animal> filterByGender() {
        List<Animal> animals = new ArrayList<>(animalDao.getAll());
        Comparator<Animal> comparator = Comparator.comparing(Animal::getGender);
        animals.sort(comparator);
        return animals;
    }

    @Override
    public List<Animal> clear() {
        animalDao.getAll().clear();
        return animalDao.getAll();
    }
}
