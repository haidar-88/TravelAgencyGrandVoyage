package grandvoyage.software.project.controller.UserPaymentSubsystem;

import grandvoyage.software.project.domain.Payment;
import grandvoyage.software.project.service.Payment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paymentGateway")
public class Payment_Controller {

    private final Payment_Service paymentService;

    @Autowired
    public Payment_Controller(Payment_Service paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("initiatePayment")
    public Payment initiatePayment(Payment payment) {
        return paymentService.initiatePayment(payment);
    }

}
