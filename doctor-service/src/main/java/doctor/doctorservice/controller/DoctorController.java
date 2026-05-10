package doctor.doctorservice.controller;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {


    @GetMapping("/search")
    @RateLimiter(name = "searchDoctorLimit", fallbackMethod = "rateLimitFallback")
    public List<String> searchDoctors() {

        return List.of(
                "Dr. Nguyễn Văn A",
                "Dr. Trần Văn B",
                "Dr. Lê Văn C"
        );
    }

    public List<String> rateLimitFallback(Exception e) {
        throw new RuntimeException("qua nhiều yêu cầu");
    }
}
