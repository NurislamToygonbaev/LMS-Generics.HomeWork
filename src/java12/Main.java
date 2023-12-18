package java12;

import java12.dao.impl.AnimalDaoImpl;
import java12.dao.impl.PersonDaoImpl;
import java12.db.DataBase;
import java12.enums.Gender;
import java12.model.Animal;
import java12.model.Person;
import java12.service.GenericService;
import java12.service.impl.AnimalServiceImpl;
import java12.service.impl.PersonServiceImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        GenericService<Person> person = new PersonServiceImpl(new PersonDaoImpl(dataBase));
        GenericService<Animal> animal = new AnimalServiceImpl(new AnimalDaoImpl(dataBase));


        if (person.add(new Person(1L, "Nurislam", 23, Gender.MALE))){
            System.out.println("Successfully added");
        } else System.out.println("Incorrect type!");


        if (person.add(new Person(2L, "Nurlan", 20, Gender.MALE))){
            System.out.println("Successfully added");
        } else System.out.println("Incorrect type!");


        if (person.add(Arrays.asList(
                new Person(3L, "Zaripbek", 21, Gender.MALE),
                new Person(4L, "Aiturgan", 18, Gender.FEMALE),
                new Person(5L, "Gulumkan", 18, Gender.FEMALE)
        ))){
            System.out.println("Successfully added");
        } else System.out.println("Incorrect type!");


        System.out.println(person.getById(4L));

        System.out.println(person.getAll());

        System.out.println(person.sortByName());

        System.out.println(person.filterByGender());

        System.out.println(person.clear());



        if (animal.add(new Animal(1L, "Buka", 3, Gender.MALE))){
            System.out.println("Successfully added");
        } else System.out.println("Incorrect type!");


        if (animal.add(new Animal(2L, "It", 5, Gender.FEMALE))){
            System.out.println("Successfully added");
        } else System.out.println("Incorrect type!");


        if (animal.add(Arrays.asList(
                new Animal(3L, "Myshyk", 1, Gender.FEMALE),
                new Animal(4L, "Burkut", 7, Gender.MALE),
                new Animal(5L, "Koi", 3, Gender.MALE)
        ))){
            System.out.println("Successfully added");
        } else System.out.println("Incorrect type!");


        System.out.println(animal.getById(4L));


        System.out.println(animal.getAll());


        System.out.println(animal.sortByName());


        System.out.println(animal.filterByGender());


        System.out.println(animal.clear());

    }
}