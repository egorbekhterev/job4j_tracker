package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("The password must have symbols.");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Length of the password must be between 8 and 32 symbols.");
        }
        String[] exceptions = {"qwerty", "12345", "password", "admin", "user"};
        boolean upper = false;
        boolean lower = false;
        boolean dig = false;
        boolean letOrDig = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper = true;
            }
            if (Character.isLowerCase(ch)) {
                lower = true;
            }
            if (Character.isDigit(ch)) {
                dig = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                letOrDig = true;
            }
            if (upper && lower && dig && letOrDig) {
                break;
            }
        }
        if (!upper) {
            throw new IllegalArgumentException("The password must have at least one UpperCase symbol.");
        }
        if (!lower) {
            throw new IllegalArgumentException("The password must have at least one LowerCase symbol.");
        }
        if (!dig) {
            throw new IllegalArgumentException("Password must have at least one digit.");
        }
        if (!letOrDig) {
            throw new IllegalArgumentException("Password must have at least one special symbol.");
        }
        for (String except: exceptions) {
            if (password.toLowerCase().contains(except)) {
                throw new IllegalArgumentException("Your password consists of such words: qwerty, 12345, password, admin, user. You must avoid them.");
            }
        }
        return "The password has been successfully created.";
    }
}