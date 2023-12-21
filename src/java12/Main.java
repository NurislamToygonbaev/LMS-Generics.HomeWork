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
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        GenericService<Person> person = new PersonServiceImpl(new PersonDaoImpl(dataBase));
        GenericService<Animal> animal = new AnimalServiceImpl(new AnimalDaoImpl(dataBase));
        Scanner scanner = new Scanner(System.in);
        loop:
        while (true) {
            try {
                menu();
                switch (scanner.nextInt()) {
                    case 0 -> {break loop;}
                    case 1 -> System.out.println(person.add(new Person(1L, "Nurislam", 23, Gender.MALE)));
                    case 2 -> System.out.println(person.add(addPersons()));
                    case 3 -> System.out.println(person.getById(1L));
                    case 4 -> System.out.println(person.getAll());
                    case 5 -> System.out.println(person.sortByName(1));
                    case 6 -> System.out.println(person.sortByName(2));
                    case 7 -> {
                        try {
                            System.out.println(person.filterByGender(1));
                        } catch (NotFoundException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 8 -> {
                        try {
                            System.out.println(person.filterByGender(2));
                        } catch (NotFoundException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 9 -> System.out.println(person.clear());
                    case 10 -> System.out.println(animal.add(new Animal(1L, "Buka", 3, Gender.MALE)));
                    case 11 -> System.out.println(animal.add(addAnimals()));
                    case 12 -> System.out.println(animal.getById(1L));
                    case 13 -> System.out.println(animal.getAll());
                    case 14 -> System.out.println(animal.sortByName(1));
                    case 15 -> System.out.println(animal.sortByName(2));
                    case 16 -> {
                        try {
                            System.out.println(animal.filterByGender(1));
                        } catch (NotFoundException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 17 -> {
                        try {
                            System.out.println(animal.filterByGender(2));
                        } catch (NotFoundException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    case 18 -> System.out.println(animal.clear());
                    default -> System.out.println("Incorrect choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter valid Integer");
                scanner.next();
            }
        }
    }

    private static List<Animal> addAnimals() {
        return Arrays.asList(
                new Animal(2L, "It", 5, Gender.FEMALE),
                new Animal(3L, "Myshyk", 1, Gender.FEMALE),
                new Animal(4L, "Burkut", 7, Gender.MALE),
                new Animal(5L, "Koi", 3, Gender.MALE)
        );
    }

    private static List<Person> addPersons() {
        return Arrays.asList(
                new Person(3L, "Zaripbek", 21, Gender.MALE),
                new Person(4L, "Aiturgan", 18, Gender.FEMALE),
                new Person(5L, "Gulumkan", 18, Gender.FEMALE),
                new Person(2L, "Nurlan", 20, Gender.MALE)
        );
    }


    private static void menu() {
        System.out.println("""
                      Person                     Animal
                1. add person                 10. add animal
                2. add persons                11. add animals
                3. get by id                  12. get by id
                4. get all                    13. get all
                5. sort by name asc           14. sort by name asc
                6. sort by name desc          15. sort by name desc
                7. filter by gender female    16. filter by gender female
                8. filter by gender male      17. filter by gender male
                9. clear                      18. clear
                                 0. EXIT
                """);
    }

}