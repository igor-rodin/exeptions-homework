package lesson3.task2;

import lesson3.task2.exceptions.WrongLoginException;
import lesson3.task2.exceptions.WrongPasswordException;

public class Task2 {

    public static final String LOGIN_OR_PASSWORD_IS_NULL_MESSAGE = "Логин и пароль не должны быть null";

    public static void main(String[] args) {
        String login = "log234";
        String password = "_$67876ghj";
        String confirmPassword = "_$67876ghj";
        System.out.println(logIn(login, password, confirmPassword));
    }

    public static boolean logIn(String login, String password, String confirmPassword) {
        if (login == null || password == null || confirmPassword == null) {
            System.out.println(LOGIN_OR_PASSWORD_IS_NULL_MESSAGE);
            return false;
        }

        try {
            LogInValidator.validateLogin(login);
            LogInValidator.validateAndConfirmPassword(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }
}
