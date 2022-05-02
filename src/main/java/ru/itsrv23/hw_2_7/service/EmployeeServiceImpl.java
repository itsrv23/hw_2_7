package ru.itsrv23.hw_2_7.service;

import org.springframework.stereotype.Service;
import ru.itsrv23.hw_2_7.entity.Employee;
import ru.itsrv23.hw_2_7.exceptions.EmployeeFullBookExceptions;
import ru.itsrv23.hw_2_7.exceptions.EmployeeIsExistsException;
import ru.itsrv23.hw_2_7.exceptions.EmployeeNotFoundException;

import java.util.Arrays;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Employee[] employeeBook = new Employee[3];

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employeeBook=" + Arrays.toString(employeeBook) +
                '}';
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (findIdEmployee(firstName, lastName) != null) {
            throw new EmployeeIsExistsException();
        } else {
            for (int i = 0; i < employeeBook.length; i++) {
                if (employeeBook[i] == null) {
                    employeeBook[i] = new Employee(firstName, lastName);
                    return employeeBook[i];

                } else {
                    if (i == employeeBook.length - 1) {
                        System.out.println("Employee book is full");
                        throw new EmployeeFullBookExceptions();
                    }
                }
            }
        }
        return null;
    }


    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Integer idEmployee = findIdEmployee(firstName, lastName);
        if (idEmployee == null) {
            throw new EmployeeNotFoundException();
        } else {
            Employee tmp = employeeBook[idEmployee];
            employeeBook[idEmployee] = null;
            return tmp;
        }

    }

    @Override
    public Integer findIdEmployee(String firstName, String lastName) {
//        System.out.println("employeeBook = " + Arrays.toString(employeeBook));
        for (int i = 0; i < employeeBook.length; i++) {
            if (employeeBook[i] != null) {
                if (employeeBook[i].getFirstName().equals(firstName) && employeeBook[i].getLastName().equals(lastName)) {
                    return i;
                }
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Integer idEmployee = findIdEmployee(firstName, lastName);
        if (idEmployee != null) {
            return employeeBook[idEmployee];
        }
        throw new EmployeeNotFoundException();
    }


}

