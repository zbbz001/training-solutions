package week03;

import java.util.ArrayList;
import java.util.List;

public class Position {
    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", bonus=" + bonus +
                '}';
    }

    public static void main(String[] args) {
        List<Position> positionList = new ArrayList<>();

        positionList.add(new Position("Marketing Coordinator", 100_000));
        positionList.add(new Position("President of Sales", 1_000_000));
        positionList.add(new Position("Project Manager", 200_000));
        positionList.add(new Position("Medical Assistant", 500_000));
        positionList.add(new Position("Photographer", 50_000));

        for(Position position:positionList) {
            if(position.getBonus() > 150_000) {
                System.out.println(position);
            }
        }
    }
}
