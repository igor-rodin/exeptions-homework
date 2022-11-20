package lesson3.task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataParser {

    public static LocalDate parseBirthDate(String value) throws IllegalArgumentException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(value, dateFormatter);
        } catch (DateTimeParseException e) {
            String errorMessage = String.format("Неверный формат для даты рождения - %s", value);
            throw new IllegalArgumentException(errorMessage);
        }
        return birthDate;
    }

    public static String parsePhoneNumber(String value) throws IllegalArgumentException {
        if (value == null || value.length() != 10 || !containsOnlyDigits(value)) {
            String errorMessage = String.format("%s не является допустимым значением для номера телефона", value);
            throw new IllegalArgumentException(errorMessage);
        }
        return String.format("8 %s %s-%s-%s", value.substring(0, 3), value.substring(3, 6),
                value.substring(6, 8), value.substring(8));
    }

    public static Sex parseSex(String value) throws IllegalArgumentException {
        if (value == null || value.length() != 1
                || (!"f".equals(value) && !"m".equals(value))) {
            String errorMessage = String.format("Неверный формат для пола - %s (допустимые значения - f, m)", value);
            throw new IllegalArgumentException(errorMessage);
        }
        return switch (value) {
            case "f" -> Sex.FEMALE;
            case "m" -> Sex.MALE;
            default -> throw new IllegalArgumentException();
        };
    }

    private static boolean containsOnlyDigits(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
