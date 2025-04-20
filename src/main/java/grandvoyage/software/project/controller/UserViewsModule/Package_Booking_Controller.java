package grandvoyage.software.project.controller.UserViewsModule;


import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Travel_Booking;
import grandvoyage.software.project.service.Customer_Service;
import grandvoyage.software.project.service.Package_Booking_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("packageBooking")
public class Package_Booking_Controller {

    private final Customer_Service customerService;
    private final Package_Booking_Service packageBookingService;

    @Autowired
    public Package_Booking_Controller(Customer_Service customerService, Package_Booking_Service packageBookingService) {
        this.customerService = customerService;
        this.packageBookingService = packageBookingService;
    }

    @GetMapping("/email/{email}/password/{password}")
    public List<Travel_Booking> getBookingsById(@RequestParam(required = true) String email, @RequestParam(required = true) String password) {
        Customer customer = customerService.getCustomerByEmailAndPassword(email, password);
        return packageBookingService.findCustomerBooking(customer);
    }
}
