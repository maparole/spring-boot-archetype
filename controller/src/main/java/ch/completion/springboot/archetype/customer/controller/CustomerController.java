package ch.completion.springboot.archetype.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.completion.springboot.archetype.customer.domain.aggregate.Customer;
import ch.completion.springboot.archetype.customer.domain.service.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping("customer/{customerId}")
	public Mono<Customer> getCustomer(@PathVariable Integer customerId) {
		logger.info("Inside CustomerController getCustomer........");
		return customerService.getCustomerById(customerId);
	}

	@GetMapping("customerAll")
	public Flux<Customer> getCustomerAll() {
		logger.info("Inside CustomerController getCustomerAll........");
		return customerService.getCustomerAll();
	}
}
