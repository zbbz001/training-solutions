package statemachine.typewriter;

public enum TypeWriterState {
    LOWERCASE {
        @Override
        TypeWriterState next() {
            return TypeWriterState.UPPERCASE;
        }
    },
    UPPERCASE {
        @Override
        TypeWriterState next() {
            return TypeWriterState.LOWERCASE;
        }
    };

    abstract TypeWriterState next();
}
