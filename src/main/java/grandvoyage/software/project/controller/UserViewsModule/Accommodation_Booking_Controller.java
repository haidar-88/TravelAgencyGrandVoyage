package grandvoyage.software.project.controller.UserViewsModule;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.Accommodation_Booking;
import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Travel_Booking;
import grandvoyage.software.project.service.Accommodation_Booking_Service;
import grandvoyage.software.project.service.Customer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/accommodationBooking")
public class Accommodation_Booking_Controller {

    private final Accommodation_Booking_Service accommodationBookingService;
    private final Customer_Service customerService;

    @Autowired
    public Accommodation_Booking_Controller(Accommodation_Booking_Service accommodationBookingService, Customer_Service customerService) {
        this.accommodationBookingService = accommodationBookingService;
        this.customerService = customerService;
    }

    @PostMapping("/getAccomodationBookingsByID")
    public List<Accommodation_Booking> getBookingsById(@RequestBody LoginRequest loginRequest ) {
        Customer customer = customerService.getCustomerByEmailAndPassword(
                loginRequest.getEmail(), loginRequest.getPassword());
        return accommodationBookingService.findCustomerBooking(customer);
    }

}
