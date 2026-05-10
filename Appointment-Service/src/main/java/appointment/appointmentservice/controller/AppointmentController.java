package appointment.appointmentservice.controller;

import appointment.appointmentservice.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {


    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<?> getDoctorInfo(@PathVariable Long doctorId) {
        return appointmentService.getDoctorInfo(doctorId);
    }


    @GetMapping("/patient/{patientId}")
    public ResponseEntity<?> getPatientInfo(@PathVariable Long patientId) {
        return appointmentService.getPatientInfo(patientId);
    }




}
