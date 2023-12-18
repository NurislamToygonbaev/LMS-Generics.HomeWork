package java12.db;

import java12.model.Animal;
import java12.model.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataBase {

    private List<Person> persons = new LinkedList<>();

    private List<Animal> animals = new LinkedList<>();


    public <T> Boolean add(T t) {
        if (t instanceof Person) return persons.add((Person) t);
        else if (t instanceof Animal) return animals.add((Animal) t);
        throw new RuntimeException("Incorrect!");
    }

//    public <T> Boolean add(List<T> t) {
//        T firstType = t.get(0);
//        if (t instanceof Person) return persons.addAll(list(t, Person.class));
//        else if (t instanceof Animal) return animals.addAll(list(t, Animal.class));
//        throw new IllegalArgumentException("Incorrect");
//    }

    public <T> Boolean remove(T type) {
        if (type instanceof Person) return persons.remove((Person) type);
        else if (type instanceof Animal) return animals.remove((Animal) type);
        throw new RuntimeException("Incorrect!");
    }

    public List<Person> personList(){
        return persons;
    }

    public List<Animal> animalList(){
        return animals;
    }

//    private <T> Boolean instance(T type, Class<?> c) {
//        return c.isInstance(type);
//    }

//    private <E> List<E> list(List<?> lists, Class<E> elementType) {
//        List<E> result = new ArrayList<>();
//        for (Object obj : lists) {
//            if (!elementType.isInstance(obj)) {
//                throw new IllegalArgumentException("Incorrect type!");
//            }
//            result.add((E) obj);
//        }
//        return result;
//    }
}
