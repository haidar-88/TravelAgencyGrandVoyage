package grandvoyage.software.project.controller.AccountManagementModule;

import grandvoyage.software.project.domain.ServiceProvider;
import grandvoyage.software.project.service.Service_Provider_Account_Creation_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/serviceProviderAccountCreation")
public class Service_Provider_Account_Creation_Controller {

    private final Service_Provider_Account_Creation_Service serviceProviderAccountCreationService;

    @Autowired
    public Service_Provider_Account_Creation_Controller(Service_Provider_Account_Creation_Service serviceProviderAccountCreationService) {
        this.serviceProviderAccountCreationService = serviceProviderAccountCreationService;
    }

    @PostMapping("/createAccount")
    public ServiceProvider createServiceProviderAccount(String company_name, String company_email,
                                                        int company_number, String email_address,
                                                        String password){

        return serviceProviderAccountCreationService.createServiceProviderAccount(company_name, company_email,
                company_number, email_address, password);

    }

}
