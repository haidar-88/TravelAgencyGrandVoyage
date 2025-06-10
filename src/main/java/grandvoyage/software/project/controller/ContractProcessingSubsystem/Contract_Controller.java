package grandvoyage.software.project.controller.ContractProcessingSubsystem;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.*;
import grandvoyage.software.project.service.Contract_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import grandvoyage.software.project.service.Service_Provider_Service;
import java.util.Date;

@RestController
@RequestMapping("/contracts")
public class Contract_Controller {

    private final Contract_Service contract_service;
    private final Service_Provider_Service service_provider__service;

    @Autowired
    public Contract_Controller(Contract_Service contract_service, Service_Provider_Service spService) {
        this.contract_service = contract_service;
        this.service_provider__service = spService;
    }

    @PostMapping("/isValidOwner")
    public boolean IsValidContractOwner(@RequestBody LoginRequest loginRequest) {
            ServiceProvider serviceProvider = service_provider__service.findByEmailAndPassword(
                    loginRequest.getEmail(), loginRequest.getPassword());
            return contract_service.existsContractBySP(serviceProvider);
    }

    @PostMapping("/AddContract")
    public Contract addContract(@RequestParam (required = true) Date start_date,
                                @RequestParam (required = true) Date end_date,
                                @RequestParam (required = true) String status,
                                @RequestParam (required = true) String service_provided,
                                @RequestParam (required = true) String company_name,
                                @RequestBody LoginRequest loginRequest
                            ) {
        return contract_service.createContract(start_date, end_date, status, service_provided,
                company_name, loginRequest.getEmail(), loginRequest.getPassword());
    }

}

