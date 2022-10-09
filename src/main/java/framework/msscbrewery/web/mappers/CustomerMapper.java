package framework.msscbrewery.web.mappers;

import framework.msscbrewery.domain.Customer;
import framework.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerToCustomerDto(Customer customer);

    CustomerDto customerDtoToCustomer(CustomerDto customerDto);
}
