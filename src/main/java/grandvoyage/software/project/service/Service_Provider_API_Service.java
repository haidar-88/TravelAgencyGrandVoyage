package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.ServiceProvider;
import grandvoyage.software.project.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return spRepository.findByEmailAddressAndPassword(email, password);
    }

}


