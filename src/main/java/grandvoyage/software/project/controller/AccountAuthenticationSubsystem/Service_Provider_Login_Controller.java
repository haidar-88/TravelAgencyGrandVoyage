package grandvoyage.software.project.controller.AccountAuthenticationSubsystem;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.ServiceProvider;
import grandvoyage.software.project.service.Service_Provider_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Service_Provider_Login")
public class Service_Provider_Login_Controller {

    private final Service_Provider_Service service_provider__service;

    @Autowired
    public Service_Provider_Login_Controller(Service_Provider_Service service_provider__service) {
        this.service_provider__service = service_provider__service;
    }

    @PostMapping("/ValidCredentials")
    public ServiceProvider findByEmailAndPassword(@RequestBody LoginRequest loginRequest) {
        return service_provider__service.findByEmailAndPassword(
                loginRequest.getEmail(), loginRequest.getPassword());
    }
}
