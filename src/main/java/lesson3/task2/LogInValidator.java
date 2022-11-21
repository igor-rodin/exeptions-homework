package lesson3.task2;

import lesson3.task2.exceptions.WrongLoginException;
import lesson3.task2.exceptions.WrongPasswordException;


public class LogInValidator {
    public static final String WRONG_LOGIN_MESSAGE = "Логин не удовлетворяет необходимым критериям.\n" +
            "-должен содержать только латинские буквы, цифры и знак подчеркивания.\n" +
            "-длина должна быть меньше 20 символов.";
    public static final String WRONG_PASSWORD_MESSAGE = "Пароль не удовлетворяет необходимым критериям.\n" +
            "-должен содержать только латинские буквы, цифры и знак подчеркивания.\n" +
            "-длина должна быть меньше 20 символов.";
    public static final String PASSWORD_NOT_EQUAL_MESSAGE = "Пароли не совпадают.";
    public static final String VALID_LOGIN_PATTERN = "\\w{1,19}";
    public static final String VALID_PASSWORD_PATTERN = "\\w{1,19}";

    public static void validateLogin(final String login) throws WrongLoginException {
        if (!login.matches(VALID_LOGIN_PATTERN)) {
            throw new WrongLoginException(WRONG_LOGIN_MESSAGE);
        }
    }

    public static void validateAndConfirmPassword(final String password, final String confirmPassword)
            throws WrongPasswordException {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException(PASSWORD_NOT_EQUAL_MESSAGE);
        }

        if (!password.matches(VALID_PASSWORD_PATTERN)) {
            throw new WrongPasswordException(WRONG_PASSWORD_MESSAGE);
        }
    }
}
