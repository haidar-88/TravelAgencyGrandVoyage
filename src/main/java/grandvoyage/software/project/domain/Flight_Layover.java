package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FLIGHT_LAYOVER")
public class Flight_Layover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int layover_id;

    @ManyToOne
    @JoinColumn(name = "flight_listing_id")
    private Flight_Detail flight;

    private String layover_airport_name;
    private String start_time, end_time;
}
