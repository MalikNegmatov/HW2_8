package myskypro.employeebook.service;

import myskypro.employeebook.entity.Employee;
import myskypro.employeebook.exception.EmployeeAlreadyAddedException;
import myskypro.employeebook.exception.EmployeeNotFoundException;
import myskypro.employeebook.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    //private final List<Employee> employees = new ArrayList<>();
    private final Map<String, Employee> employees = new HashMap<>();

    private final static int MAX_SIZE = 2;

    public Employee add(String firstName, String lastName, double salary, int departmentId) {

        if (employees.size() >= MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }

        Employee newEmployee = new Employee(firstName, lastName, salary, departmentId);

        if (employees.containsKey(newEmployee.toString())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }

        employees.put(newEmployee.toString(), newEmployee);

        return newEmployee;
    }

    public Employee find(String firstName, String lastName, double salary, int departmentId) {
        Employee employeeForFound = new Employee(firstName, lastName, salary, departmentId);
        if (employees.containsKey(employeeForFound.toString())) {
            return employees.get(employeeForFound.toString());
        }
        throw new
                EmployeeNotFoundException("Такого сотрудника нет");
    }

    public Employee remove(String firstName, String lastName, double salary, int departmentId) {
        Employee employeeForRemove = new Employee(firstName, lastName, salary, departmentId);

        if (employees.containsKey(employeeForRemove.toString())) {
            return employees.remove(employeeForRemove.toString());
        }
        throw new EmployeeNotFoundException("Сотрудник не удален - не был найден в базе");
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

}
