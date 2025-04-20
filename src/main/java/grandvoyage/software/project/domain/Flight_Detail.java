package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FLIGHT_DETAIL")
public class Flight_Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flight_listing_id;

    @OneToMany(mappedBy = "flight")
    private List<Flight_Layover> layovers;

    private String airline_name;
    private int flight_number;
    private String departure_airport, arrival_airport;
    private String departure_terminal, arrival_terminal;
    private String departure_gate, arrival_gate;
    private int flight_duration;
    private String cabin_class;
    private int baggage_allowance;
    private boolean meal_included;

}
