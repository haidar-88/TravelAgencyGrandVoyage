package grandvoyage.software.project.service;

import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Contract_Service  {


    private final  ContractRepository contractRepository;
    private final Service_Provider_API_Service service_provider_api_service;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public Contract_Service(ContractRepository contractRepository, Service_Provider_API_Service service_provider_api_service,
                            PasswordEncoder passwordEncoder) {
        this.contractRepository = contractRepository;
        this.service_provider_api_service = service_provider_api_service;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean existsContractBySP(ServiceProvider sp){
            if(service_provider_api_service.findByEmailAndPassword(sp.getEmail_address(), sp.getPassword()) != null) {
                return contractRepository.existsActiveContractByContract_ownerEquals(sp);
            } else {
                return false;
            }
        }

    public Contract createContract(Date start_date, Date end_date, String status, String service_provided,
                                   String company_name, String email, String password){
        List<Travel_Listing> travelListings = new ArrayList<>();
        List<Accommodation_Listing> accommodationListings = new ArrayList<>();
        ServiceProvider sp = service_provider_api_service.findByEmailAndPassword(email, passwordEncoder.encode(password));

        Contract contract = new Contract();
        contract.setStart_date(start_date);
        contract.setEnd_date(end_date);
        contract.setStatus(status);
        contract.setService_provided(service_provided);
        contract.setTravel_listings(travelListings);
        contract.setAccommodation_listings(accommodationListings);
        contract.setContract_owner(sp);
        contract.setCompany_name(company_name);

        return contract;
    }
}
