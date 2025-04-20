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
@Table(name = "ACCOMMODATION_MEALS")
public class Accommodation_Meals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String amenity_name;

    @ManyToOne
    @JoinColumn(name = "accommodation_listing_id", nullable = false)
    private Accommodation_Listing accommodationListing;
}
