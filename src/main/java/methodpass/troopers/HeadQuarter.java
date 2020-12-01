package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {
    private List<Trooper> trooperList = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return trooperList;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("The trooper cannot be null");
        }

        trooperList.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        Trooper trooper = findTrooperByName(name);

        if (trooper != null) {
            trooper.changePosition(target);
        }
    }

    public void moveClosestTrooper(Position target) {
        Trooper trooper = findClosestTrooper(target);
        if (trooper != null) {
            moveTrooper(trooper, target);
        }
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }

    private Trooper findClosestTrooper(Position target) {
        if (trooperList.isEmpty()) {
            return null;
        }

        Trooper closestTrooper = trooperList.get(0);

        for (Trooper trooper : trooperList) {
            if (trooper.distanceFrom(target) < closestTrooper.distanceFrom(target)) {
                closestTrooper = trooper;
            }
        }

        return closestTrooper;
    }

    private Trooper findTrooperByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("THe trooper's name cannot be null or empty.");
        }

        for (Trooper trooper : trooperList) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }

        return null;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
