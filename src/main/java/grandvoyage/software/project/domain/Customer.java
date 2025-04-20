package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @OneToMany(mappedBy = "customer")
    private List<Package_Booking> package_bookings;

    @OneToMany(mappedBy = "customer")
    private List<Travel_Booking> travel_bookings;

    @OneToMany(mappedBy = "customer")
    private List<Accommodation_Booking> accommodation_bookings;

    private String username;
    private String first_name, last_name;
    private int phone_number;
    private String email;
    private String password;
    private String address;
    private Date registration_date;
    private char gender;
    private String nationality;
}
