package exam03retake02;

public enum State {
    COMPLETED {
        @Override
        State next() {
            return State.NON_COMPLETED;
        }
    }, NON_COMPLETED {
        @Override
        State next() {
            return State.COMPLETED;
        }
    };

    abstract State next();
}
