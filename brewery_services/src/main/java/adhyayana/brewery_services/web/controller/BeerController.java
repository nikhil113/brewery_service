package adhyayana.brewery_services.web.controller;

import adhyayana.brewery_services.web.model.BeerDTO;
import adhyayana.brewery_services.web.service.BeerService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/beer")
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getBeer(@PathVariable("id") int id){
        if(Objects.isNull(id)){
            return ResponseEntity.badRequest().build();
        }
        try{
            Optional<BeerDTO> beerDTOOptional = beerService.getBeerDTO(id);
            return beerDTOOptional.isPresent() ? ResponseEntity.ok(beerDTOOptional.get()) : ResponseEntity.noContent().build();
        }catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity addBeer(@RequestBody BeerDTO beerDTO){
        System.out.println(beerDTO);
        if(Objects.isNull(beerDTO) || !StringUtils.hasText(beerDTO.getBeerName()) || !StringUtils.hasText(beerDTO.getBeerStyle()) || Objects.isNull(beerDTO.getUpc())){
            return ResponseEntity.badRequest().body("Either beerDTO is null or beerName/beerStyle/upc is null/empty");
        }

        try{
            Integer beerId = beerService.addBeer(beerDTO);
            return ResponseEntity.ok(beerId);
        }catch(Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

}
