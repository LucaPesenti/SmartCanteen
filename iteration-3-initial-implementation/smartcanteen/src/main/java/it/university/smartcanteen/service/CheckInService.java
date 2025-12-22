package it.university.smartcanteen.service;

import org.springframework.stereotype.Service;

import it.university.smartcanteen.config.Employee;
import it.university.smartcanteen.repository.EmployeeRepository;

import java.time.LocalDateTime;

@Service
public class CheckInService {

    private final EmployeeRepository employeeRepository;

    public CheckInService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public LocalDateTime checkIn(String employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));

        return LocalDateTime.now();
    }
}
