package array;

public class ArrayHandler {

    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();

        int daysIndexOfWeek[] = new int[]{1,2,3,4,5,6,7};
        int weekendDaysIndexOfWeek[] = new int[]{6,7};

        System.out.println(arrayHandler.contains(daysIndexOfWeek, 1));
        System.out.println(arrayHandler.contains(weekendDaysIndexOfWeek, 1));

        System.out.println(arrayHandler.find(daysIndexOfWeek, 2));
        System.out.println(arrayHandler.find(weekendDaysIndexOfWeek, 1));
    }

    public boolean contains(int[] source, int itemToFind) {
        for (int i = 0; i < source.length; i++) {
            if(itemToFind == source[i]) {
                return true;
            }
        }

        return false;
    }

    public int find(int[] source, int itemToFind) {
        for (int i = 0; i < source.length; i++) {
            if(itemToFind == source[i]) {
                return i;
            }
        }

        return -1;
    }

}
