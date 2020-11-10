package typeconversion.dataloss;

public class DataLoss {

    public static void main(String[] args) {
        new DataLoss().dataLoss();
    }

    long longNumber = 0;

    public void dataLoss() {
        for(int i = 0; i < 3;){
            float floatNumber = (float)longNumber;
            long longNumberFromFloat = (long)floatNumber;

            if(longNumberFromFloat != longNumber){
                System.out.println(longNumber + "---" + longNumberFromFloat);
                System.out.println(Long.toBinaryString(longNumber) + "---"+ Long.toBinaryString(longNumberFromFloat));
                i++;
            }
            longNumber++;
        }






    }


}
