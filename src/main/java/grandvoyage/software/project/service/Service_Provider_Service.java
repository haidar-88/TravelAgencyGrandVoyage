package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.ServiceProvider;
import grandvoyage.software.project.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Service_Provider_Service {

    private final PasswordEncoder passwordEncoder;
    private final ServiceProviderRepository spRepository;

    @Autowired
    public Service_Provider_Service(ServiceProviderRepository serviceProviderRepository, PasswordEncoder passwordEncoder) {
        this.spRepository = serviceProviderRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ServiceProvider findByEmailAndPassword(String email, String password) {
        return spRepository.findByEmailAddressAndPassword(email, passwordEncoder.encode(password));
    }

    public long getTotalTravelListingsBySP(String email, String password) {
        return spRepository.getTotalTravelListings(email, password);
    }
    public long getTotalAccommodationListingsBySP(String email, String password) {
        return spRepository.getTotalAccommodationListings(email, password);
    }
}


