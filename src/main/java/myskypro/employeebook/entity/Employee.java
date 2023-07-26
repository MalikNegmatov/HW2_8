package myskypro.employeebook.entity;
import java.util.Objects;

public class Employee {
    private final String firstName;   // Имя
    private final String lastName;    // Фамилия
    private final double salary; // Размер зарплаты
    private final int departmentId; // номер отдела

    // Конструктор класса
    public Employee(String firstName, String lastName, double salary, int departmentId) {
        this.firstName = formatField(firstName);
        this.lastName = formatField(lastName);
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public double getSalary() {
        return salary;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        return s.append(this.getFirstName()).append(getLastName()).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!firstName.equals(employee.firstName)) return false;
        return lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    /**
     * Метод форматирования вводимых значений в поля ФИО
     *
     * @param field - строка переданная в конструктор
     * @return возвращает в формате первая заглавная, остальные строчные
     */
    protected final String formatField(String field) {
        return field.substring(0, 1).toUpperCase() + field.substring(1).toLowerCase();
    }
}