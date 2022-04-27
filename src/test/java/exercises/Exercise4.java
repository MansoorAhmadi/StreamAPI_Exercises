package exercises;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise4 {

    @Test
    public void distinct() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        List<Integer> duplicate = numbers.stream().distinct().collect(Collectors.toList());
        assertThat(duplicate).hasSize(9);
        System.out.println(duplicate);
    }

    @Test
    public void distinctWithSet() throws Exception {
        final List<Integer> numbers = ImmutableList.of(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);

        Set<Integer> distinctNumbers = numbers.stream().collect(Collectors.toSet());
        assertThat(distinctNumbers).hasSize(9);
        System.out.println(distinctNumbers);
    }
}
