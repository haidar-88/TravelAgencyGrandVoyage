package grandvoyage.software.project.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "SERVICE_PROVIDER")
public class ServiceProvider {

    public ServiceProvider(int company_id, String company_name, String company_email, int company_number, String email_address, String password, List<Contract> contracts) {
        this.company_id = company_id;
        this.company_name = company_name;
        this.company_email = company_email;
        this.company_number = company_number;
        this.email_address = email_address;
        this.password = password;
        this.contracts = contracts;
    }

    public ServiceProvider() {}

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


    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public int getCompany_number() {
        return company_number;
    }

    public void setCompany_number(int company_number) {
        this.company_number = company_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
