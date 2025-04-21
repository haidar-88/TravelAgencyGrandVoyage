package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class User_API_Service {
    private final CustomerRepository customerRepository;

    @Autowired
    public User_API_Service(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public boolean existsServiceProviderByCompany_emailEquals(String email, String password){
        return customerRepository.existsByEmailEqualsAndPasswordEquals(email, password);
    }
    public Customer getCustomerByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailEqualsAndPasswordEquals(email, password);
    }
    }






