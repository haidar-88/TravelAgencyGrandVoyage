package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class User_Service {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public User_Service(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Customer findByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, passwordEncoder.encode(password));
    }
}






