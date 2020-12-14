package week08d01;

public enum CellDoorStatus {
    OPEN {
        @Override
        CellDoorStatus nextStatus() {
            return CellDoorStatus.CLOSE;
        }
    }, CLOSE {
        @Override
        CellDoorStatus nextStatus() {
            return CellDoorStatus.OPEN;
        }
    };

    abstract CellDoorStatus nextStatus();
}
