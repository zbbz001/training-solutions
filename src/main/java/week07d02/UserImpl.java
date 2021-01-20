package week07d02;

public class UserImpl implements User {
    private String username;
    private String firstName;
    private String lastName;

    public UserImpl(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }
}
