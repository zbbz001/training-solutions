package lambdastreams.baseoperations;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {
    private List<Integer> intList;

    public Numbers(List<Integer> intList) {
        this.intList = intList;
    }

    public Optional<Integer> min() {
        return intList.stream().min(Comparator.naturalOrder());
    }

    public Integer sum() {
        return intList.stream().reduce(0, Integer::sum);
    }

    public boolean isAllPositive() {
        return intList.stream().allMatch(e -> e > 0);
    }

    public Set<Integer> getDistinctElements() {
        return intList.stream().collect(Collectors.toSet());
    }
}
