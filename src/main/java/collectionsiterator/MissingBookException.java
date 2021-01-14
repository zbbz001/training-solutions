package collectionsiterator;

public class MissingBookException extends RuntimeException {
    private String message;

    public MissingBookException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
