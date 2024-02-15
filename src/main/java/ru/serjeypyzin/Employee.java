package ru.serjeypyzin;

/*
Каждый сотрудник должен иметь следующие атрибуты:
        Табельный номер
        Номер телефона
        Имя
        Стаж

 */
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Employee {

    private int serviceNumber;
    private String employeeName;
    private String phoneNumber;
    private double workExperience;

    private static int lastServiceNumber = 0;
    public Employee(String employeeName, String phoneNumber, double workExperience){
        this.serviceNumber = ++lastServiceNumber;
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник:\nТабельный номер: %d, Имя Фамилия: %s, телефон: %s, стаж: %.2f"
                , serviceNumber
                , employeeName
                , phoneNumber
                , workExperience);
    }

    public static Employee randomGenerationEmployee(){
        Random random = new Random();

        String[] firstNameArray = {"Иван", "Алексей", "Мария", "Елена", "Андрей"
                , "Ольга", "Петр", "Светлана", "Наталья", "Дмитрий"};
        String[] lastNameArray = {"Иванов", "Петров", "Сидоров", "Смирнов", "Козлов"
                , "Морозов", "Новиков", "Кузнецова", "Павлова", "Волкова"};
        String[] phoneNumbers = {"123456789", "987654321", "555555555", "111222333", "999888777"};
        double minWorkExperience = 1.0;
        double maxWorkExperience = 20.0;

        String firstName = firstNameArray[random.nextInt(firstNameArray.length)];
        String lastName = lastNameArray[random.nextInt(lastNameArray.length)];
        String employeeName = String.format("%s %s",firstName, lastName);

        String phoneNumber = phoneNumbers[random.nextInt(phoneNumbers.length)];

        double workExperience = minWorkExperience + (maxWorkExperience - minWorkExperience) * random.nextDouble();

        return new Employee(employeeName, phoneNumber, workExperience);
    }

}
