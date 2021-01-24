package KissDryYagni;

import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.comparators.ReverseComparator;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
//        BiPredicate<T, T> predicate = (v1, v2) -> comparator.compare(v1, v2) < 0;
        return findMaxMin(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
//        BiPredicate<T, T> predicate = (v1, v2) -> comparator.compare(v1, v2) > 0;
        return findMaxMin(value, comparator.reversed());
    }

    public <T> T findMaxMin(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (T t : value) {
            if (comparator.compare(t, result) > 0) {
                result = t;
            }
        }
        return result;
    }
}
