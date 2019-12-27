package dagimon.springframework.sf5restbrewery.mappers;

import dagimon.springframework.sf5restbrewery.domain.Beer;
import dagimon.springframework.sf5restbrewery.domain.Beer.BeerBuilder;
import dagimon.springframework.sf5restbrewery.domain.BeerStyleEnum;
import dagimon.springframework.sf5restbrewery.web.model.BeerDto;
import dagimon.springframework.sf5restbrewery.web.model.BeerDto.BeerDtoBuilder;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-27T21:31:22+0100",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.1 (Oracle Corporation)"
)
@Component
public class BeerMapperImpl implements BeerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        if ( beer == null ) {
            return null;
        }

        BeerDtoBuilder beerDto = BeerDto.builder();

        beerDto.id( beer.getId() );
        beerDto.beerName( beer.getBeerName() );
        if ( beer.getBeerStyle() != null ) {
            beerDto.beerStyle( beer.getBeerStyle().name() );
        }
        beerDto.upc( beer.getUpc() );
        beerDto.createdDate( dateMapper.asOffsetDateTime( beer.getCreatedDate() ) );
        beerDto.lastUpdatedDate( dateMapper.asOffsetDateTime( beer.getLastUpdatedDate() ) );

        return beerDto.build();
    }

    @Override
    public Beer beerDtoToBeer(BeerDto dto) {
        if ( dto == null ) {
            return null;
        }

        BeerBuilder beer = Beer.builder();

        beer.id( dto.getId() );
        beer.beerName( dto.getBeerName() );
        if ( dto.getBeerStyle() != null ) {
            beer.beerStyle( Enum.valueOf( BeerStyleEnum.class, dto.getBeerStyle() ) );
        }
        beer.upc( dto.getUpc() );
        beer.createdDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beer.lastUpdatedDate( dateMapper.asTimestamp( dto.getLastUpdatedDate() ) );

        return beer.build();
    }
}
