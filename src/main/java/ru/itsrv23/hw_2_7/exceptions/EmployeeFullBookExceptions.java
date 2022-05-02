package ru.itsrv23.hw_2_7.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeFullBookExceptions extends RuntimeException{
    public EmployeeFullBookExceptions() {
    }
}
