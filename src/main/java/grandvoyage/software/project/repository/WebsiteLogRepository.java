package grandvoyage.software.project.repository;

import grandvoyage.software.project.domain.Website_Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsiteLogRepository extends JpaRepository<Website_Log, Integer> {
}

