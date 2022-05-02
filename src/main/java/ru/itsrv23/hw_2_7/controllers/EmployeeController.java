package ru.itsrv23.hw_2_7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itsrv23.hw_2_7.entity.Employee;
import ru.itsrv23.hw_2_7.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = "/find")
    public Employee findEmployee(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee deleteEmployee(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping()
    public String employee() {
        return  "<br>" +
                "1. По адресу /employee/add?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON, т. е. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\" }, или исключение со статусом 500 Internal Server Error в случае переполнения массива или 400 Bad Request в случае, когда сотрудник уже существует.\n" +
                "<br>" +
                "2. По адресу /employee/remove?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON, т. е. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\" }, или исключение со статусом 404 Not Found, если сотрудник отсутствует.\n" +
                "<br>" +
                "3. По адресу /employee/find?firstName=Ivan&lastName=Ivanov должен вернуться объект Employee в формате JSON, т. е. { \"firstName\": \"Ivan\", \"lastName\": \"Ivanov\" }, или исключение со статусом 404 Not Found, если такой сотрудник отсутствует.\n";
    }

}
