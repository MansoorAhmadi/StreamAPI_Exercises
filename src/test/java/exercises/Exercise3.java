package exercises;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise3 {

    @Test
    public void min(){
//        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

        final List<Integer> numbers = ImmutableList.of(2, 3, 100, 23, 93, 99, 1);

        Integer minimum = numbers.stream().min(Comparator.naturalOrder()).get();
        assertThat(minimum).isEqualTo(1);
        System.out.println(minimum);
    }

    @Test
    public void max() throws Exception {
        //given
        final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);

        //when
        Integer maximum = numbers.stream().max(Comparator.naturalOrder()).get();

        //then
        assertThat(maximum).isEqualTo(100);
        System.out.println(maximum);
    }
}
