package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.Contract;
import grandvoyage.software.project.domain.ServiceProvider;
import grandvoyage.software.project.repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Service_Provider_Account_Creation_Service {

    private final ServiceProviderRepository serviceProviderRepository;

    @Autowired
    public Service_Provider_Account_Creation_Service(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }


    public ServiceProvider createServiceProviderAccount(String companyName, String companyEmail, int companyNumber,
                                                        String emailAddress, String password) {
        List<Contract> contractList = new ArrayList<>();

        ServiceProvider sp = new ServiceProvider();
        sp.setCompany_email(companyEmail);
        sp.setCompany_name(companyName);
        sp.setCompany_number(companyNumber);
        sp.setPassword(password);
        sp.setEmail_address(emailAddress);
        sp.setContracts(contractList);

        return serviceProviderRepository.save(sp);
    }
}
