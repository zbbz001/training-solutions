package week05d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    private UserValidator userValidator = new UserValidator();
    private List<User> userList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        userList.add(new User("Cody Coder", 22));
        userList.add(new User("John James Rambo", 11));
    }

    @Test
    public void testUserValidatorNameIsEmptyString() {
        userList.add(new User("", 44));

        Exception ex = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(userList));
        assertEquals("The user's name cannot be empty or null.", ex.getMessage());
    }

    @Test
    public void testUserValidatorNameIsNullString() {
        userList.add(new User(null, 44));

        Exception ex = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(userList));
        assertEquals("The user's name cannot be empty or null.", ex.getMessage());
    }

    @Test
    public void testUserValidatorUnderTheAgeLimit() {
        userList.add(new User("Mickey Mouse", -10));

        Exception ex = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(userList));
        assertEquals("The user's age must be between 0 and 120. age:-10", ex.getMessage());
    }

    @Test
    public void testUserValidatorAboveTheAgeLimit() {
        userList.add(new User("Mickey Mouse", 130));

        Exception ex = assertThrows(IllegalArgumentException.class, () -> userValidator.validate(userList));
        assertEquals("The user's age must be between 0 and 120. age:130", ex.getMessage());
    }
}