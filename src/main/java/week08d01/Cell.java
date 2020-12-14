package week08d01;

public class Cell {
    private CellDoorStatus cellDoorStatus;
    private int cellNumber;

    public Cell(int cellNumber) {
        cellDoorStatus = CellDoorStatus.CLOSE;
        this.cellNumber = cellNumber;
    }

    public void lockRotate() {
        cellDoorStatus = cellDoorStatus.nextStatus();
    }

    public CellDoorStatus getCellDoorStatus() {
        return cellDoorStatus;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "cellDoorStatus=" + cellDoorStatus +
                ", cellNumber=" + cellNumber +
                '}';
    }
}
