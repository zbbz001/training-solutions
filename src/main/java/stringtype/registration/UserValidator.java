package stringtype.registration;

public class UserValidator {

    public boolean isValidUsername(String username) {
        return username.length() > 0;
    }

    public boolean isValidPassword(String password1, String password2) {
        return password1.equals(password2) && password1.length() > 7;
    }

    public boolean isValidEmail(String email) {
        int positionAtSign = email.indexOf("@");

        int positionDot = email.substring(positionAtSign + 1).indexOf(".");

        return positionAtSign > 0 && positionDot > 0 && positionDot < email.length() - 1;
    }
}
