package java12.service.impl;

public class MyGeneratorId {
    public static long idPerson = 0;

    public static long idAnimal = 0;

    public static long generatorIdPerson(){
        return (++idPerson);
    }

    public static long generatorIdAnimal(){
        return (++idAnimal);
    }
}
