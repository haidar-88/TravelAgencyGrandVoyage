package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.repository.UserAccountCreationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;

@Service
public class User_Account_Creation_Service {

    private final UserAccountCreationRepository userAccountCreationRepository;

    @Autowired
    public User_Account_Creation_Service(UserAccountCreationRepository userAccountCreationRepository) {
        this.userAccountCreationRepository = userAccountCreationRepository;
    }


    public Customer createNewUser(String username, String firstName, String lastName,
                                  Integer phoneNumber, String email, String password,
                                  String address, Date registrationDate, Character gender,
                                  String nationality) {
        if (userAccountCreationRepository.existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists");
        }
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setFirst_name(firstName);
        customer.setLast_name(lastName);
        customer.setPhone_number(phoneNumber);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setAddress(address);
        customer.setRegistration_date(registrationDate);
        customer.setGender(gender);
        customer.setNationality(nationality);
        customer.setPackage_bookings(new ArrayList<>());
        customer.setAccommodation_bookings(new ArrayList<>());
        customer.setTravel_bookings(new ArrayList<>());
        return userAccountCreationRepository.save(customer);
    }
}
