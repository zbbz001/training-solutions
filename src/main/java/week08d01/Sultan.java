package week08d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {
    public List<Cell> openDoors(List<Cell> cells, int day) {
        List<Cell> openedCells = new ArrayList<>();

        for (int i = 0; i < day; i++) {
            rotateCellLock(cells, i);
        }

        return openedDoors(cells);
    }

    private void rotateCellLock(List<Cell> cells, int i) {
        for (Cell cell : cells) {
            if (cell.getCellNumber() % (i + 1) == 0) {
                cell.lockRotate();
            }
        }
    }

    private List<Cell> openedDoors(List<Cell> cells) {
        List<Cell> openedCells = new ArrayList<>();

        for (Cell cell : cells) {
            if (cell.getCellDoorStatus() == CellDoorStatus.OPEN) {
                openedCells.add(cell);
            }
        }

        return openedCells;
    }
}
