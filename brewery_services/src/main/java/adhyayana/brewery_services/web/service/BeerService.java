package adhyayana.brewery_services.web.service;

import adhyayana.brewery_services.web.model.BeerDTO;
import adhyayana.brewery_services.web.repositories.BeerRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class BeerService {

    private BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository){
        this.beerRepository = beerRepository;
    }

    public Optional<BeerDTO> getBeerDTO(@NonNull Integer id){
        return beerRepository.findById(id);
    }

    public Integer addBeer(@NonNull BeerDTO beerDTO){
        return beerRepository.save(beerDTO).getId();
    }

}
