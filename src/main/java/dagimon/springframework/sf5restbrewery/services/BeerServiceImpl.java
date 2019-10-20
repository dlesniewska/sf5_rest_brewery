package dagimon.springframework.sf5restbrewery.services;

import dagimon.springframework.sf5restbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Some beer 2 be")
                .beerStyle("Pale Ale").build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
      log.info("Updating a beer with id {}", beerId);
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.info("Deleting a beer with id {}", beerId);
    }
}
