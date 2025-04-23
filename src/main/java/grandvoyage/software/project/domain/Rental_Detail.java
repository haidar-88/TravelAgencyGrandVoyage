package grandvoyage.software.project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "RENTAL_DETAIL")
public class Rental_Detail {

    @Id
    private Integer rental_listing_id;

    @OneToOne(mappedBy = "rental")
    private Accommodation_Listing accommodation_listing;

    private String property_name;
    private String property_type;
    private String host_name;
    private Integer host_contact_number;
    private Integer max_guests;
    private Integer bedrooms;
    private Integer rental_price;
    private String rental_agreement;
}
