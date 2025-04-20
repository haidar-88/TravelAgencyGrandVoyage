package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WEBSITE_LOG")
public class Website_Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int log_id;

    private Date log_date;
    private Boolean is_logged_in;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String user_location;
    private String website_url;
    private double response_time;
}
