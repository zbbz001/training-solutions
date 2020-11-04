package arraylist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {
    private List<String> capsuleColors = new ArrayList<>();

    public void addLast(String color) {
        capsuleColors.add(color);
    }

    public void addFirst(String color) {
        capsuleColors.add(0, color);
    }

    public void removeFirst() {
        capsuleColors.remove(0);
    }

    public void removeLast() {
        capsuleColors.remove(capsuleColors.size() - 1);
    }

    public List<String> getColors() {
        return capsuleColors;
    }


    public static void main(String[] args) {
        Capsules capsules = new Capsules();

        capsules.addLast("Blue");
        System.out.println(capsules.getColors().toString());
        capsules.addFirst("White");
        System.out.println(capsules.getColors().toString());
        capsules.addLast("Green");
        System.out.println(capsules.getColors().toString());
        capsules.addFirst("Yellow");
        System.out.println(capsules.getColors().toString());

        capsules.removeFirst();
        System.out.println(capsules.getColors().toString());
        capsules.removeLast();
        System.out.println(capsules.getColors().toString());
        System.out.println();
        System.out.println();
        System.out.println("___Bónusz 1");

        List<String> storedCapsules = capsules.getColors();
        System.out.println(storedCapsules.toString());
        storedCapsules.clear();
        storedCapsules = capsules.getColors();
        System.out.println(storedCapsules.toString());
    }
}