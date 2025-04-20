package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
        boolean existsActiveContractByContract_owner(int owner_id);
}

