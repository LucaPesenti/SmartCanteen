package it.university.smartcanteen.repository;

import org.springframework.stereotype.Repository;

import it.university.smartcanteen.config.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class EmployeeRepository {

    private final Map<String, Employee> employees = new HashMap<>();

    public EmployeeRepository() {
        employees.put("E1", new Employee("E1", "Mario Rossi"));
        employees.put("E2", new Employee("E2", "Giulia Bianchi"));
    }

    public Optional<Employee> findById(String id) {
        return Optional.ofNullable(employees.get(id));
    }
}