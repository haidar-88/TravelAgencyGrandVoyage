package grandvoyage.software.project.controller.UserViewsModule;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Travel_Booking;
import grandvoyage.software.project.service.Customer_Service;
import grandvoyage.software.project.service.Travel_Booking_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travelBooking")
public class Travel_Booking_Controller {

    private final Customer_Service customerService;
    private final Travel_Booking_Service travelBookingService;

    public Travel_Booking_Controller(Customer_Service customerService, Travel_Booking_Service travelBookingService) {
        this.customerService = customerService;
        this.travelBookingService = travelBookingService;
    }

    @PostMapping("/getTravelBookingByID")
    public List<Travel_Booking> getBookingsById(@RequestBody LoginRequest loginRequest) {
        Customer customer = customerService.getCustomerByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        return travelBookingService.findCustomerBooking(customer);
    }
}
