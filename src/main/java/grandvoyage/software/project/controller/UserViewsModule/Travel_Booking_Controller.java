package grandvoyage.software.project.controller.UserViewsModule;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Travel_Booking;
import grandvoyage.software.project.service.Customer_Service;
import grandvoyage.software.project.service.Travel_Booking_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/travelBooking")
public class Travel_Booking_Controller {

    private final Customer_Service customerService;
    private final Travel_Booking_Service travelBookingService;

    public Travel_Booking_Controller(Customer_Service customerService, Travel_Booking_Service travelBookingService) {
        this.customerService = customerService;
        this.travelBookingService = travelBookingService;
    }

    @GetMapping("/email/{email}/password/{password}")
    public List<Travel_Booking> getBookingsById(@RequestParam(required = true) String email, @RequestParam(required = true) String password) {
        Customer customer = customerService.getCustomerByEmailAndPassword(email, password);
        return travelBookingService.findCustomerBooking(customer);
    }
}
