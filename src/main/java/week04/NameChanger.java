package week04;

public class NameChanger {
    private String fullName;

    public NameChanger(String fullName) {
        if(fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Invalid Name: "+fullName);
        }

        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void changeFirstName(String firstName) {
        String[] parts = fullName.split(" ");

        fullName = parts[0] + " " + firstName;
    }

}

