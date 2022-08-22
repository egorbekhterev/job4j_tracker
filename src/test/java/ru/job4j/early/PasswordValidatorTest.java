package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordValidatorTest {

    @Test
    void whenNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("The password must have symbols.");
    }

    @Test
    void whenIncorrectLength() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("IncorL");
                });
        assertThat(exception.getMessage()).isEqualTo("Length of the password must be between 8 and 32 symbols.");
    }

    @Test
    void whenUpperCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("uppercase");
                });
        assertThat(exception.getMessage()).isEqualTo("The password must have at least one UpperCase symbol.");
    }

    @Test
    void whenLowerCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("LOWERCASE");
                });
        assertThat(exception.getMessage()).isEqualTo("The password must have at least one LowerCase symbol.");
    }

    @Test
    void whenNoDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("oNEdigit");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must have at least one digit.");
    }

    @Test
    void whenNoSpecialSymbols() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("N0SpecialSymbols");
                });
        assertThat(exception.getMessage()).isEqualTo("Password must have at least one special symbol.");
    }

    @Test
    void whenConsistOfExceptions() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("User123:");
                });
        assertThat(exception.getMessage()).isEqualTo("Your password consists of such words: qwerty, 12345, password, admin, user. You must avoid them.");
    }

    @Test
    void whenCorrectPass() {
        assertThat(PasswordValidator.validate("C0rrectPas$$word")).isEqualTo("The password has been successfully created.");
    }
}
