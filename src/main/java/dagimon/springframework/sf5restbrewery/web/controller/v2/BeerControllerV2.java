package dagimon.springframework.sf5restbrewery.web.controller.v2;

import dagimon.springframework.sf5restbrewery.services.v2.BeerServiceV2;
import dagimon.springframework.sf5restbrewery.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

//    public BeerControllerV2(BeerServiceV2 beerService) { //provided by lombok library
//        this.beerService = beerService;
//    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull @PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDtoV2 beerDto) { //accepts a post of beerdto data in json
        //BeerDtoV2 savedBeerDto =  beerService.saveNewBeer(beerDto); substituted by lombok val
        log.debug("in handle post...");
        val savedBeerDto = beerService.saveNewBeer(beerDto);

        //HttpHeaders responseHeaders = new HttpHeaders(); //subsituted by lombok var
        var responseHeaders = new HttpHeaders();
        responseHeaders.add("Location", "/api/v2/beer/" + savedBeerDto.getId().toString());
        return new ResponseEntity(responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {
        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  //204, ok but no content
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeerById(beerId);
    }
}
