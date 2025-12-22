package application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import application.dto.CheckInResponse;
import application.service.CheckInService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final CheckInService checkInService;

    public EmployeeController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @PostMapping("/{employeeId}/check-in")
    public ResponseEntity<CheckInResponse> checkIn(@PathVariable String employeeId) {

        LocalDateTime checkInTime = checkInService.checkIn(employeeId);

        return ResponseEntity.ok(
                new CheckInResponse(employeeId, checkInTime)
        );
    }
}
