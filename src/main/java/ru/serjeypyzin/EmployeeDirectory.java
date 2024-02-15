package ru.serjeypyzin;

/*
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
*/
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmployeeDirectory {

    private List<Employee> employees;

    public void addedNewEmployeeToEmployeeDirectory (Employee employee){
        employees.add(employee);
    }

    public Employee findEmployeeByServicesNumber (List<Employee> employees, int serviceNumber) {
        return employees.stream()
                .filter(employee -> employee.getServiceNumber() == serviceNumber)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findEmployeeByWorkExperience(List<Employee> employees, int workExperience){
        return employees.stream()
                .filter(employee -> employee.getWorkExperience() == workExperience)
                .collect(Collectors.toList());
    }

    public List<String> findPhoneNumbersByEmployeeName (List<Employee> employees, String employeeName) {
     return employees.stream()
                .filter(employee -> employee.getEmployeeName().equals(employeeName))
                .map(Employee::getPhoneNumber)
                .collect(Collectors.toList());

    }
}
