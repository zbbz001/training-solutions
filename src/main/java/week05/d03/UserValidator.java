package week05.d03;

import java.util.List;

public class UserValidator {
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;

    public void validate(List<User> userList) {
        for (User user : userList) {
            if (isEmpty(user.getName())) {
                throw new IllegalArgumentException("The user's name cannot be empty or null.");
            }

            if (!checkAge(user.getAge())) {
                StringBuilder msg = new StringBuilder("The user's age must be between ");
                msg.append(MIN_AGE);
                msg.append(" and ");
                msg.append(MAX_AGE);
                msg.append(". age:");
                msg.append(user.getAge());

                throw new IllegalArgumentException(msg.toString());
            }
        }
    }

    private boolean checkAge(int age) {
        return age >= MIN_AGE && age < MAX_AGE;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }
}
