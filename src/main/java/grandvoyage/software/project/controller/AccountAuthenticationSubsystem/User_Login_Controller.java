package grandvoyage.software.project.controller.AccountAuthenticationSubsystem;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserLogin")
public class User_Login_Controller {

    private final User_Service userApiService;

    @Autowired
    public User_Login_Controller(User_Service userApiService) {
        this.userApiService = userApiService;
    }

    @PostMapping("/ValidCredentials")
    public Customer login(@RequestBody LoginRequest loginRequest) {
        return userApiService.findByEmailAndPassword(
                loginRequest.getEmail(), loginRequest.getPassword());
    }


}
