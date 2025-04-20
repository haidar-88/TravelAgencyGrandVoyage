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
@Table(name = "CONTRACT")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-INCREMENT
    private int contract_id;

    @OneToMany(mappedBy = "contract")
    private List<Accommodation_Listing> accommodation_listings;

    @OneToMany(mappedBy = "contract")
    private List<Travel_Listing> travel_listings;

    @ManyToOne
    @JoinColumn(name = "contract_owner", nullable = false)
    private ServiceProvider contract_owner;

    private Date start_date, end_date;
    @Column(name = "status", columnDefinition = "VARCHAR(20) DEFAULT 'PENDING_VALIDATION'")
    private String status;
    private String service_provided;
    private String company_name;
}
