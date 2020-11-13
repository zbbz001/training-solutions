package stringbasic.pets;

import java.time.LocalDate;

public class Pet {
    private String name;
    private LocalDate yearOfBirth;
    private Gender sex;
    private String registrationNumber;

    public Pet(String name, LocalDate yearOfBirth, Gender sex, String registrationNumber) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.sex = sex;
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
