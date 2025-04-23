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
@Table(name = "HOTEL_DETAIL")
public class Hotel_Detail {

    @Id
    private int hotel_id;

    @OneToOne(mappedBy = "hotel")
    private Accommodation_Listing accommodation_listing;

    private String hotel_name;
    private String hotel_chain;
    private String room_type;
    private Integer number_of_people;
    private String meals_included;
    private Integer star_rating;
}
