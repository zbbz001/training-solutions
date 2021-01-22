package week12d03;

public class AgeSorter {

    public int[] sortAges(int[] ages) {
        int[] allAges = new int[131];
        int[] sorted = new int[ages.length];
        int index = 0;

        for (int age : ages) {
            allAges[age]++;
        }

        for (int age = 0; age < allAges.length; age++) {
            if (allAges[age] != 0) {
                for (int j = 0; j < allAges[age]; j++) {
                    sorted[index] = age;
                    index++;
                }
            }
        }

        return sorted;
    }
}
