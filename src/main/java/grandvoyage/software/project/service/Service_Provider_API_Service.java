package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Contract;
import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.domain.ServiceProvider;
import grandvoyage.software.project.repository.CustomerRepository;
import grandvoyage.software.project.repository.ServiceProviderRepository;
import jakarta.persistence.OneToMany;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Service_Provider_API_Service {
    private final ServiceProviderRepository spRepository;

    @Autowired
    public Service_Provider_API_Service(ServiceProviderRepository serviceProviderRepository) {
        this.spRepository = serviceProviderRepository;
    }

    public boolean existsServiceProviderByCompany_emailEquals(String email, String password){
        return spRepository.existsServiceProviderByEmail_addressEqualsAndPasswordEquals(email, password);
    }
    public ServiceProvider getCustomerByEmailAndPassword(String email, String password) {
        return spRepository.findByEmail_addressEqualsAndPasswordEquals(email, password);
    }

}


