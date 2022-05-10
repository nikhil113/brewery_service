package adhyayana.brewery_services.web.repositories;

import adhyayana.brewery_services.web.model.BeerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<BeerDTO, Integer> {
}
