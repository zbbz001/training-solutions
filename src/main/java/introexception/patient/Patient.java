package introexception.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String socialSecurityNumber, int yearOfBirth) {
        if(name.equals("") || name == null) {
            throw new IllegalArgumentException("A név nem lehet üres!");
        }

        if(yearOfBirth < 1990) {
            throw new IllegalArgumentException("A születési évnek nagyobbnak kell lennie 1990-nél!");
        }

        if (!new SsnValidator().isValidSsn(socialSecurityNumber))
            throw new IllegalArgumentException("Hibás ssn szám: " + socialSecurityNumber);

        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
