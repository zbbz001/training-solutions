package array;

public class ArrayMain {

    public static void main(String[] args) {
        String[] daysOfWeek = {"hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap"};

        System.out.println(daysOfWeek[1]);

        int[] powersOfTwo = new int[5];

        for(int i = 0; i < powersOfTwo.length; i++) {
            if(i == 0) {
                powersOfTwo[i] = 1;
            } else {
                powersOfTwo[i] = powersOfTwo[i - 1] * 2;
            }
        }

        for(int item:powersOfTwo) {
            System.out.println(item);
        }

        boolean[] bools = new boolean[6];

        for(int i = 0; i < bools.length; i++) {
            if(i > 0) {
                bools[i] = !bools[i - 1];
            }
        }

        for(boolean item:bools) {
            System.out.println(item);
        }
    }

}
