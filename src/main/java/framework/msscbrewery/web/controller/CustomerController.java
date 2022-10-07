package framework.msscbrewery.web.controller;

import framework.msscbrewery.services.CustomerService;
import framework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/customer/")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity handleCustomerPost(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomerDto = customerService.saveNewCustomer(customerDto);

        HttpHeaders customerHeaders = new HttpHeaders();
        customerHeaders.add("Location", "/api/v1/customer/" + savedCustomerDto.getId().toString());

        return new ResponseEntity(customerHeaders, HttpStatus.CREATED);
    }
    @PutMapping({"/{customerId}"})
    public ResponseEntity customerUpdate(@PathVariable("customerId") UUID customerId, @Valid @RequestBody CustomerDto customerDto) {

        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") UUID customerId) {

        customerService.deleteById(customerId);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add((constraintViolation.getPropertyPath() + " : " + constraintViolation.getMessage()));
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
