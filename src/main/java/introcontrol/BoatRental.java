package introcontrol;

import java.util.Scanner;

public class BoatRental {

    public static void main(String[] args) {
        int boat1Capacity = 5;
        int boat2Capacity = 3;
        int boat3Capacity = 2;
        int sumCapacity = boat1Capacity + boat2Capacity + boat3Capacity;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hány fő jött csónakázni?");

        int numOfTourist = scanner.nextInt();

        if(numOfTourist > 3) {
            System.out.println("Megkapják az 5ös csónakot!");
            numOfTourist -= 5;
            sumCapacity -= 5;
        }

        if(numOfTourist > 2) {
            System.out.println("Megkapják az 3as csónakot!");
            numOfTourist -= 3;
            sumCapacity -= 3;
        }

        if(numOfTourist > 0) {
            System.out.println("Megkapják az 2as csónakot!");
            numOfTourist -= 2;
            sumCapacity -= 2;
        }

        if(numOfTourist > sumCapacity){
            System.out.println(numOfTourist + " fő most nem fér be!");
        } else {
            System.out.println(sumCapacity + " hely még szabad!");
        }
    }
}
