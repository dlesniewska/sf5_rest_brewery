package dagimon.springframework.sf5restbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data //getters&setters, equals&hashcode
@Builder
@NoArgsConstructor
@AllArgsConstructor //builder pattern
public class BeerDto {
    private UUID id;
    private String beerName;
    private String beerStyle;
    private String upc;
}
