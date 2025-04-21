package grandvoyage.software.project.controller.AccountManagementModule;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.ServiceProvider;
import grandvoyage.software.project.service.Service_Provider_Account_Creation_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/serviceProviderAccountCreation")
public class Service_Provider_Account_Creation_Controller {

    private final Service_Provider_Account_Creation_Service serviceProviderAccountCreationService;

    @Autowired
    public Service_Provider_Account_Creation_Controller(Service_Provider_Account_Creation_Service serviceProviderAccountCreationService) {
        this.serviceProviderAccountCreationService = serviceProviderAccountCreationService;
    }

    @PostMapping("/createAccount")
    public ServiceProvider createServiceProviderAccount(@RequestParam String company_name, @RequestParam String company_email,
                                                        @RequestParam int company_number, @RequestBody LoginRequest loginRequest){

        return serviceProviderAccountCreationService.createServiceProviderAccount(company_name, company_email,
                company_number, loginRequest.getEmail(), loginRequest.getPassword());

    }

}
