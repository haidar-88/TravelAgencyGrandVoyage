package grandvoyage.software.project.controller.ServiceProviderActionsSubsystem;

import grandvoyage.software.project.DataTransferObjects.LoginRequest;
import grandvoyage.software.project.service.Service_Provider_API_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AccessStatistics")
public class Access_Listing_Statistics_Controller {

    private final Service_Provider_API_Service service_provider_api;

    @Autowired
    public Access_Listing_Statistics_Controller(Service_Provider_API_Service service_provider) {
        this.service_provider_api = service_provider;
    }

    @GetMapping("/getTotalListingsBySP")
    public Long getTotalListings(@RequestBody LoginRequest loginRequest) {
        return service_provider_api.getTotalAccommodationListingsBySP(loginRequest.getEmail(),
                loginRequest.getPassword()) + service_provider_api.getTotalTravelListingsBySP(
                loginRequest.getEmail(), loginRequest.getPassword()
        );
    }
}
