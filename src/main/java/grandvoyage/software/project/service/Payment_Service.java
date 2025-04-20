package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.repository.AccommodationBookingRepository;
import grandvoyage.software.project.repository.PackageBookingRepository;
import grandvoyage.software.project.repository.PaymentRepository;
import grandvoyage.software.project.repository.TravelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class Payment_Service {

    private final PaymentRepository paymentRepository;
    private final Accommodation_Booking_Service Accommodation_Booking_Service;
    private final Travel_Booking_Service Travel_Booking_Service;
    private final Package_Booking_Service Package_Booking_Service;
    private final AccommodationBookingRepository accommodationBookingRepository;
    private final TravelBookingRepository travelBookingRepository;
    private final PackageBookingRepository packageBookingRepository;

    @Autowired
    public Payment_Service(PaymentRepository paymentRepository,
                           Accommodation_Booking_Service Accommodation_Booking_Service,
                           Travel_Booking_Service Travel_Booking_Service,
                           Package_Booking_Service Package_Booking_Service, AccommodationBookingRepository accommodationBookingRepository, TravelBookingRepository travelBookingRepository, PackageBookingRepository packageBookingRepository) {
        this.paymentRepository = paymentRepository;
        this.Accommodation_Booking_Service = Accommodation_Booking_Service;
        this.Travel_Booking_Service = Travel_Booking_Service;
        this.Package_Booking_Service = Package_Booking_Service;
        this.accommodationBookingRepository = accommodationBookingRepository;
        this.travelBookingRepository = travelBookingRepository;
        this.packageBookingRepository = packageBookingRepository;
    }


    public Payment initiatePayment(Payment payment) {
        //validate info and add listing to customer booking
        Customer customer = payment.getCustomer();
        if (payment.getAccommodationListing()!=null){
            Accommodation_Booking booking = Accommodation_Booking_Service.createAccommodationBooking(payment.getAccommodationListing());
            if (customer.getAccommodation_bookings() == null) {
                customer.setAccommodation_bookings(new ArrayList<>());
            }
            booking.setPayment(payment);
            booking.setCustomer(customer);
            if (accommodationBookingRepository.save(booking) == null){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Could not save accommodation booking");
            }
            customer.getAccommodation_bookings().add(booking);
        }
        if (payment.getTravelListing()!=null){
            Travel_Booking booking = Travel_Booking_Service.createTravelBooking(payment.getTravelListing());
            if (customer.getTravel_bookings() == null) {
                customer.setTravel_bookings(new ArrayList<>());
            }
            booking.setPayment(payment);
            booking.setCustomer(customer);
            if (travelBookingRepository.save(booking) == null){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Could not save accommodation booking");
            }
            customer.getTravel_bookings().add(booking);
        }
        if (payment.getPackageListing()!=null){
            Package_Booking booking = Package_Booking_Service.createPackageBooking(payment.getPackageListing());
            if (customer.getPackage_bookings() == null) {
                customer.setPackage_bookings(new ArrayList<>());
            }
            booking.setPayment(payment);
            booking.setCustomer(customer);
            if (packageBookingRepository.save(booking) == null){
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "Could not save accommodation booking");
            }
            customer.getPackage_bookings().add(booking);
        }
        return paymentRepository.save(payment);
    }
}
