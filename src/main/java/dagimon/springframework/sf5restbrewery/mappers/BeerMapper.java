package dagimon.springframework.sf5restbrewery.mappers;

import dagimon.springframework.sf5restbrewery.domain.Beer;
import dagimon.springframework.sf5restbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
