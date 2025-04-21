package grandvoyage.software.project.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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

    public Contract() {
    }

    public Contract(int contract_id, List<Accommodation_Listing> accommodation_listings, List<Travel_Listing> travel_listings, ServiceProvider contract_owner, Date start_date, Date end_date, String status, String service_provided, String company_name) {
        this.contract_id = contract_id;
        this.accommodation_listings = accommodation_listings;
        this.travel_listings = travel_listings;
        this.contract_owner = contract_owner;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.service_provided = service_provided;
        this.company_name = company_name;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public List<Accommodation_Listing> getAccommodation_listings() {
        return accommodation_listings;
    }

    public void setAccommodation_listings(List<Accommodation_Listing> accommodation_listings) {
        this.accommodation_listings = accommodation_listings;
    }

    public List<Travel_Listing> getTravel_listings() {
        return travel_listings;
    }

    public void setTravel_listings(List<Travel_Listing> travel_listings) {
        this.travel_listings = travel_listings;
    }

    public ServiceProvider getContract_owner() {
        return contract_owner;
    }

    public void setContract_owner(ServiceProvider contract_owner) {
        this.contract_owner = contract_owner;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getService_provided() {
        return service_provided;
    }

    public void setService_provided(String service_provided) {
        this.service_provided = service_provided;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
}
