package grandvoyage.software.project.controller.AccountAuthenticationSubsystem;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.ServiceProvider;
import grandvoyage.software.project.service.Service_Provider_API_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SPLogin")
public class SP_Login_Controller {

    private final Service_Provider_API_Service service_provider_api_service;

    @Autowired
    public SP_Login_Controller(Service_Provider_API_Service service_provider_api_service) {
        this.service_provider_api_service = service_provider_api_service;
    }

    @PostMapping("/ValidCredentials")
    public boolean ValidSPCredentials(@RequestBody LoginRequest loginRequest) {

        return service_provider_api_service.existsServiceProviderByCompany_emailEquals(
                loginRequest.getEmail(), loginRequest.getPassword());
    }
}
