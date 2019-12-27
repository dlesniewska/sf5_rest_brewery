package dagimon.springframework.sf5restbrewery.web.mappers;

import dagimon.springframework.sf5restbrewery.domain.Customer;
import dagimon.springframework.sf5restbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto dto);

    CustomerDto customerToCustomerDto(Customer customer);
}
