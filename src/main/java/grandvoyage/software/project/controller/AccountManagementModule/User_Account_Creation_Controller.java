package grandvoyage.software.project.controller.AccountManagementModule;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.domain.Customer;
import grandvoyage.software.project.service.User_Account_Creation_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/userAccountCreation")
public class User_Account_Creation_Controller {

    private final User_Account_Creation_Service userAccountCreationService;

    @Autowired
    public User_Account_Creation_Controller(User_Account_Creation_Service userAccountCreationService) {
        this.userAccountCreationService = userAccountCreationService;
    }

    @PostMapping("/createNewAccount")
    public Customer createNewAccount(@RequestParam String username , @RequestParam String first_name,
                                     @RequestParam String last_name, @RequestParam Integer phone_number,
                                     @RequestBody LoginRequest loginRequest, @RequestParam String address,
                                     @RequestParam Date registration_date, @RequestParam Character gender,
                                     @RequestParam String nationality){
        return userAccountCreationService.createNewUser(username, first_name, last_name, phone_number,
                loginRequest.getEmail(), loginRequest.getPassword(), address, registration_date, gender,
                nationality);
    }
}
