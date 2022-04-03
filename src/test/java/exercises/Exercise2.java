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
}
