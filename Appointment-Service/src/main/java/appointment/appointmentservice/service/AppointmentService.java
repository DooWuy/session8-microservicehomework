package appointment.appointmentservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppointmentService {

    private final RestTemplate restTemplate;

    public AppointmentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "doctorServiceCB", fallbackMethod = "doctorServiceFallback")
    public String checkDoctorSchedule(Long doctorId) {
        String url = "http://localhost:8082/doctors/" + doctorId + "/schedule";
        return restTemplate.getForObject(url, String.class);
    }

    public String doctorServiceFallback(Long doctorId, Throwable throwable) {
        return "Doctor-Service bị lỗi hoặc quá tải , xin thử lại sau ";
    }
}
