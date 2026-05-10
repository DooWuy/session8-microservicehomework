package appointment.appointmentservice.service;

import appointment.appointmentservice.dto.ApiResponseError;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppointmentService {

    private final RestTemplate restTemplate;

    public AppointmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @CircuitBreaker(name = "doctorServiceCB", fallbackMethod = "getDoctorFallback")
    public ResponseEntity<?> getDoctorInfo(Long doctorId) {
        String url = "http://localhost:8082/doctors/" + doctorId;
        Object doctor = restTemplate.getForObject(url, Object.class);

        return ResponseEntity.ok(doctor);
    }

    public ResponseEntity<ApiResponseError> getDoctorFallback(Long doctorId, Exception e) {
        ApiResponseError error = new ApiResponseError(
                503,
                "ko the kiem tra thong tin doctor , moi thu lai sau "
        );

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
    }
}
