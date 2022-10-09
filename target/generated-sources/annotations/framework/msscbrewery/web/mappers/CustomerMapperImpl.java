package framework.msscbrewery.web.mappers;

import framework.msscbrewery.domain.Customer;
import framework.msscbrewery.web.model.CustomerDto;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-09T17:53:42+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.3 (Amazon.com Inc.)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Customer customer1 = new Customer();

        return customer1;
    }

    @Override
    public CustomerDto customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        CustomerDto customerDto1 = new CustomerDto();

        return customerDto1;
    }
}
