package ru.itsrv23.hw_2_7.entity;

import java.util.Objects;


public class Employee {
    private final String firstName;
    private final String lastName;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public Employee(String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + '}';
    }


}
