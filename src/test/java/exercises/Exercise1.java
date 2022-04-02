package exercises;

import beans.Person;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise1 {

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people

        final int limit = 10;
        int counter = 0;

        List<Person> youngPeople = Lists.newArrayList();
        for (Person person : people) {
            if (person.getAge() <=18){
                youngPeople.add(person);

                //to see 10 people from the list of 200, which is the case in here
                //once, it entered the first if condition, it will increment the counter when it equals 10, it will break
                counter++;
                if (counter == limit) break;
            }
        }
        //youngPeople will show the result all in one line
//    System.out.println(youngPeople);

        //to see the list of people line by line - we run another loop
        for (Person young : youngPeople) {
            //the call goes to .toString() method in POJO class and returns all the attributes of the Person class
            System.out.println(young);

            //this call will only return the getAge() from the .toString() method
            System.out.println(young.getAge());
        }

    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {

        //we store getPeople(which is json file reader) method from MockData class in a list called people
        List<Person> people = MockData.getPeople();

        //.filter() corresponds to if() statement
        //.limit(10) we limit the people to 10, after the filtering
        //.collect(Collectors.toList()) corresponds to everything that has been filtered should be stored as a Collection
        //And the type of the Collection is Person, which we have named it youngPeople

        //we stream, filter, limit, collect over people and store it in youngPeople
        List<Person> youngPeople =
                people.stream()
                        .filter(person -> person.getAge() <= 18)
                        .limit(10)
                        .collect(Collectors.toList());

        youngPeople.forEach(System.out::println);

    }
}
