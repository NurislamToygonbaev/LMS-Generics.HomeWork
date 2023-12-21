package java12.service.impl;

import java12.NotFoundException;
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
        try {
            return animalDao.getById(id);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.getAll();
    }

    @Override
    public List<Animal> sortByName(int i) {
        List<Animal> animals = new ArrayList<>(animalDao.getAll());
        if (i == 1){
            Comparator<Animal> comparator = Comparator.comparing(Animal::getName);
            animals.sort(comparator);
            return animals;
        } else if (i == 2) {
            Comparator<Animal> comparator = Comparator.comparing(Animal::getName).reversed();
            animals.sort(comparator);
            return animals;
        }
        throw new NotFoundException("write correct!!!");
    }

    @Override
    public List<Animal> filterByGender(int i) {
        List<Animal> animals = new ArrayList<>();
        if (i == 1){
            for (Animal animal : animalDao.getAll()) {
                if ("female".equalsIgnoreCase(String.valueOf(animal.getGender()))){
                    animals.add(animal);
                }
            }
            return animals;
        } else if (i == 2) {
            for (Animal animal : animalDao.getAll()) {
                if ("male".equalsIgnoreCase(String.valueOf(animal.getGender()))){
                    animals.add(animal);
                }
            }
            return animals;
        }
        throw new NotFoundException("write correct!!!");
    }

    @Override
    public List<Animal> clear() {
        animalDao.getAll().clear();
        return animalDao.getAll();
    }
}
