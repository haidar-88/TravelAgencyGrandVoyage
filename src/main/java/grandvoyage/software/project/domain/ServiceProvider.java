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
@Table(name = "SERVICE_PROVIDER")
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-INCREMENT
    private int company_id;

    private String company_name;
    private String company_email;
    private int company_number;
    private String email_address;
    private String password;

    @OneToMany(mappedBy = "contract_owner")
    private List<Contract> contracts;

}
