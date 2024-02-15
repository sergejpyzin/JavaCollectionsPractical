package ru.serjeypyzin;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        EmployeeDirectory employeeDirectory = new EmployeeDirectory();

        for (int i = 0; i < 50; i++) {
            employeeDirectory.addedNewEmployeeToEmployeeDirectory(Employee.randomGenerationEmployee());
        }

        System.out.println(employeeDirectory);



    }
}