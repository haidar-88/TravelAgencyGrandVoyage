package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Contract;
import grandvoyage.software.project.domain.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

        @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Contract c WHERE c.contract_owner = ?1 AND c.status = 'ACTIVE'")
        boolean existsActiveContractByContract_ownerEquals(ServiceProvider sp);
}

