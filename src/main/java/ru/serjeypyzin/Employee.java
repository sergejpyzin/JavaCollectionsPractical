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

}
