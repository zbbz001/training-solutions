package week10d05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public void findMinMaxSum(int[] arr) {
        Arrays.sort(arr);
        int min = 0;
        int max = 0;

        for (int i = 0; i < 4; i++) {
            min += arr[i];
            max += arr[arr.length - i - 1];
        }

        System.out.println("A négy legkisebb szám összege:" + min);
        System.out.println("A négy legnagyobb szám összege:" + max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        String userInput;
        System.out.println("Adjon meg számokat!");
        userInput = scanner.nextLine();
        while (!userInput.isBlank()) {
            numbers.add(Integer.parseInt(userInput));
            userInput = scanner.nextLine();
        }

        int[] numberOfArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            numberOfArray[i] = numbers.get(i);
        }

        new Calculator().findMinMaxSum(numberOfArray);
    }
}
