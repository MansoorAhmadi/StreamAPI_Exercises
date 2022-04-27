package exercises;

import beans.Car;
import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise5 {

    @Test
    public void understandingFilter() throws Exception {

        //Method #1
        ImmutableList<Car> cars = MockData.getCars();

        List<Car> filtered = cars.stream()
                .filter(car -> car.getPrice() < 20000)
                .collect(Collectors.toList());

        filtered.forEach(System.out::println);
        System.out.println(filtered.size());


        //Method #2
        ImmutableList<Car> vehicles = MockData.getCars();

        //we extracted the condition inside the api
        Predicate<Car> vehiclePredicate = car -> car.getPrice() < 20000;
        List<Car> filteredVehicle = cars.stream()
                .filter(vehiclePredicate)
                .collect(Collectors.toList());

        filteredVehicle.forEach(System.out::println);
        System.out.println(filteredVehicle.size());

    }

    @Test
    public void ourFirstMapping() throws Exception {
        // transform from one data type to another
        List<Person> people = MockData.getPeople();

    }

    @Test
    public void averageCarPrice() throws Exception {
        // calculate average of car prices

    }

    @Test
    public void test() throws Exception {

    }
}
