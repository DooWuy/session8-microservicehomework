package appointment.appointmentservice.controller;

import appointment.appointmentservice.service.AppointmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/book/{doctorId}")
    public String bookAppointment(@PathVariable Long doctorId) {
        return appointmentService.checkDoctorSchedule(doctorId);
    }




}
