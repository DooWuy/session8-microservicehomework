package appointment.appointmentservice.dto;

import java.time.LocalDateTime;

public class ApiResponseError {



    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ApiResponseError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
