package arrayofarrays;

public class ArrayOfArraysMain {

    public static void main(String[] args) {
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        int [][]multiplicationTable = arrayOfArraysMain.multiplicationTable(11);
        int [][]triangularMatrix = arrayOfArraysMain.triangularMatrix(4);
        int [][]daysOfMonths = arrayOfArraysMain.getValues();

        arrayOfArraysMain.printArrayOfArrays(multiplicationTable);
        System.out.println();
        arrayOfArraysMain.printArrayOfArrays(triangularMatrix);
        System.out.println();
        arrayOfArraysMain.printArrayOfArrays(daysOfMonths);
    }

    public int[][] getValues() {
        int[] numberOfDaysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int[][] daysOfMonths = new int[12][];


        for(int i = 0; i < 12; i++) {
            daysOfMonths[i] = new int[numberOfDaysInMonth[i]];
        }

        return daysOfMonths;
    }


    public int[][] triangularMatrix(int size) {

        int[][] triangularMatrix = new int[size][];

        for(int i = 0; i < size; i++) {
            triangularMatrix[i] = new int[i + 1];

            for(int j = 0; j < triangularMatrix[i].length; j++){
                triangularMatrix[i][j] = i;
            }
        }

        return triangularMatrix;
    }

    public int[][] multiplicationTable(int size) {
        int[][] multiplicationTable = new int[size][size];

        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++){
                multiplicationTable[i - 1][j - 1] = i * j;
            }
        }

        return multiplicationTable;
    }

    public void printArrayOfArrays(int[][] a) {
        String spaceFiller;

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                spaceFiller = " ";
                int valueLength = (a[i][j] + "").length();

                if(valueLength < 2) {
                    spaceFiller = "   ";
                }
                else if(valueLength < 3) {
                    spaceFiller = "  ";
                }

                System.out.print(spaceFiller + a[i][j]);
            }
            System.out.println();
        }
    }
}
