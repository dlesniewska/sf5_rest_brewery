package dagimon.springframework.sf5restbrewery.services.v2;

import dagimon.springframework.sf5restbrewery.web.model.v2.BeerDtoV2;
import dagimon.springframework.sf5restbrewery.web.model.v2.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName("Some beer 2 be")
                .beerStyle(BeerStyle.GOSE).build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
      log.info("Updating a beer with id {}", beerId);
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.info("Deleting a beer with id {}", beerId);
    }
}
