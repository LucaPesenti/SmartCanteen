package dto;

import java.time.LocalDateTime;

public class CheckInResponse {

    private String employeeId;
    private LocalDateTime checkInTime;

    public CheckInResponse(String employeeId, LocalDateTime checkInTime) {
        this.employeeId = employeeId;
        this.checkInTime = checkInTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }
}
