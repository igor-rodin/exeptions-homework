package lesson3.task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

enum Sex {
    MALE("m"), FEMALE("f");

    private String shortName;
    Sex(String value) {
        this.shortName = value;
    }

    String getShortName() {
        return shortName;
    }
}

public class Task1 {

    public static final int LINE_SIZE = 85;
    public static final int REQUIRED_DATA_LENGTH = 6;
    public static final int LAST_NAME_POSITION = 0;
    public static final int FIRST_NAME_POSITION = 1;
    public static final int PATRONYMIC_POSITION = 2;
    public static final int BIRTH_DATE_POSITION = 3;
    public static final int PHONE_NUMBER_POSITION = 4;
    public static final int SEX_POSITION = 5;

    public static void main(String[] args) {
        printInfo();

        String[] inputData;
        Person person;
        try {
            inputData = readInputData();
            person = parsePersonData(inputData);
            saveToCsvFile(person);
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printInfo() {
        String infoMessage = "Введите данные в следующем виде: 'фамилия имя отчество дата_рождения номер_телефона пол'.\n" +
                "- дата_рождения вводится в формате dd.mm.yyy (dd - день, mm - месяц и yyyy - год рожения) \n" +
                "- номер_телефона состоит из 10 цифр, без кода страны\n" +
                "- пол: (f, m)\n" +
                "Например, 'ivanov ivan petrovich 21.03.2001 9998137654 m'";
        System.out.println("*".repeat(LINE_SIZE));
        System.out.println(infoMessage);
        System.out.println("*".repeat(LINE_SIZE));
    }

    public static String[] readInputData() throws IllegalArgumentException {
        Scanner scanner = new Scanner(System.in);
        String[] inputData = scanner.nextLine().split(" ");
        int inputSize = inputData.length;
        if (inputSize != REQUIRED_DATA_LENGTH) {
            String errorMessage = String.format("Вы ввели %s данных.\n" +
                    "Количество данных должно быть %d, вы ввели %d",
                    inputSize > REQUIRED_DATA_LENGTH ? "больше" : "меньше", REQUIRED_DATA_LENGTH, inputSize);
            throw new IllegalArgumentException(errorMessage);
        }
        return inputData;
    }

    public static Person parsePersonData(final String[] inputData) throws IllegalArgumentException {
        Person person = new Person();
        person.setFirstName(inputData[FIRST_NAME_POSITION]);
        person.setPatronymic(inputData[PATRONYMIC_POSITION]);
        person.setLastName(inputData[LAST_NAME_POSITION]);

        person.setBirthDate(DataParser.parseBirthDate(inputData[BIRTH_DATE_POSITION]));
        person.setPhoneNumber(DataParser.parsePhoneNumber(inputData[PHONE_NUMBER_POSITION]));
        person.setSex(DataParser.parseSex(inputData[SEX_POSITION]));

        return person;
    }

    public static void saveToCsvFile(Person person) throws IOException {
        if (person == null) {
            throw new IllegalArgumentException("Person не должен быть null");
        }

        Path fileName = Path.of("src/main/resources", person.getLastName() + ".csv");
        String personData = String.format("%s,%s,%s,%s,%s,%s\n",
                person.getLastName(), person.getFirstName(), person.getPatronymic(),
                person.getFormattedBirthDate(DateTimeFormatter.ofPattern("d.MM.yyy")),
                person.getPhoneNumber(), person.getSex().getShortName());

        if (!Files.exists(fileName)) {
            try (BufferedWriter writer = Files.newBufferedWriter(fileName)) {
                writer.write("Фамилия,Имя,Отчество,Дата рождения,Телефон,Пол\n");
                writer.write(personData);
            }
        } else  {
            try (BufferedWriter writer = Files.newBufferedWriter(fileName, StandardOpenOption.APPEND)) {
                writer.write(personData);
            }
        }
    }
}
