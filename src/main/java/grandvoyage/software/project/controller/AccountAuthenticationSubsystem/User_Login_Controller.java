package grandvoyage.software.project.controller.AccountAuthenticationSubsystem;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.service.User_API_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/UserLogin")
public class User_Login_Controller {

    private final User_API_Service userApiService;

    @Autowired
    public User_Login_Controller(User_API_Service userApiService) {
        this.userApiService = userApiService;
    }

    @PostMapping("/ValidCredentials")
    public boolean validSPCredentials(@RequestBody LoginRequest loginRequest) {

        return userApiService.existsCustomerByCompany_emailEquals(
                loginRequest.getEmail(), loginRequest.getPassword());
    }


}
