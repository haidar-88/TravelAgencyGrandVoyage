package grandvoyage.software.project.controller.UserViewsModule;


import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.Package_Booking;
import grandvoyage.software.project.service.Customer_Service;
import grandvoyage.software.project.service.Package_Booking_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/packageBooking")
public class Package_Booking_Controller {

    private final Customer_Service customerService;
    private final Package_Booking_Service packageBookingService;

    @Autowired
    public Package_Booking_Controller(Customer_Service customerService, Package_Booking_Service packageBookingService) {
        this.customerService = customerService;
        this.packageBookingService = packageBookingService;
    }

    @PostMapping("/getPackageBookingsByID")
    public List<Package_Booking> getBookingsById(@RequestBody LoginRequest loginRequest) {
        Customer customer = customerService.getCustomerByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        return packageBookingService.findCustomerBooking(customer);
    }
}
