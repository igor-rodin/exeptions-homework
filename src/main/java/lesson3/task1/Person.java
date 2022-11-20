package lesson3.task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String firstName;
    private String patronymic;
    private String lastName;

    private String phoneNumber;
    private LocalDate birthDate;
    private Sex sex;

    public Person() {
    }

    public Person(String firstName, String patronymic, String lastName, String phoneNumber, LocalDate birthDate, Sex sex) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFormattedBirthDate(DateTimeFormatter formatter) {
        return formatter.format(birthDate);
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s\t%s",
                lastName, firstName, patronymic, getFormattedBirthDate(DateTimeFormatter.ofPattern("d.MM.yyy")),
                phoneNumber, sex.getShortName());
    }
}
