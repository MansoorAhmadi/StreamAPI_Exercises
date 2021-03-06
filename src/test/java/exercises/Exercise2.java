package exercises;

import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise2 {

    @Test
    public void range() throws IOException {
        System.out.println("fori = is a shortcut in Intellij to =>  for (int i = 0; i < ; i++) { }");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        //Inclusive IntStream vs Exclusive IntStream
        //Inclusive IntStream will include the last index, where exclusive will not.

        System.out.println("We chose the exclusive parameter in .range() method");
        IntStream.range(0,10).forEach(System.out::println);

        System.out.println("We chose the inclusiveStart and endInclusive parameter in .range() method");
        IntStream.rangeClosed(0,10).forEach(System.out::println);

        List<Person> people = MockData.getPeople();
        List<Person> youngPeople =
                people.stream()
                        .filter(person -> person.getAge() <= 18)
                        .limit(10)
                        .collect(Collectors.toList());

        youngPeople.forEach(System.out::println);
    }

    @Test
    public void rangeIteratingLists() throws Exception {
        List<Person> people = MockData.getPeople();

        IntStream.range(0, people.size())
                .forEach(index -> {Person person = people.get(index);
                    System.out.println(person);
        });
    }

    @Test
    public void intStreamIterate() throws Exception {
        System.out.println("STREAM");
        System.out.println("EVEN OPERATION");

        IntStream.iterate(1,operand -> operand + 1)
                        .filter(number -> number % 2==0)
                .limit(40)
                .forEach(System.out::println);

        System.out.println("STREAM");
        System.out.println("ODD OPERATION");
        IntStream.iterate(1, i -> i+1)
                .filter(value -> value % 2==1)
                .limit(40)
                .forEach(System.out::println);
    }
}
