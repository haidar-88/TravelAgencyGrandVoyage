package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CRUISE_DETAIL")
public class Cruise_Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cruise_listing_id; // Unique ID for the cruise

    private String cruise_ship_name; // Name of the ship
    private String departure_port; // Location of embarkation
    private String arrival_port; // Location of disembarkation
    private Date embarkation_date; // Start of the trip
    private Date disembarkation_date; // End of the trip
    private int number_of_nights; // Total nights on the cruise
    private String cabin_type; // Room type on the ship
}
