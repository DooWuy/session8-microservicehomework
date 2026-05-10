package doctor.doctorservice.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RequestNotPermitted.class)
    public ResponseEntity<?> handleRateLimit(RequestNotPermitted ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("status", 429);
        error.put("message", "Too Many Requests - Bạn gọi API quá nhiều.");
        error.put("timestamp", LocalDateTime.now());

        return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .body(error);
    }
}
