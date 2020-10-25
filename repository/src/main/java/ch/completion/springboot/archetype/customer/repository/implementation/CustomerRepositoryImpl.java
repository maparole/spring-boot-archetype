package ch.completion.springboot.archetype.customer.repository.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ch.completion.springboot.archetype.customer.domain.aggregate.Customer;
import ch.completion.springboot.archetype.customer.domain.repository.CustomerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

	@Override
	public Mono<Customer> getCustomerById(Integer customerId) {
		logger.info("Inside CustomerRepositoryImpl........");
		// Replace this code to retrieve from database
		Customer customer = Customer.builder().customerId(customerId).customerName("The name of customer " + customerId).build();
		return Mono.just(customer);
	}

	@Override
	public Flux<Customer> getCustomerAll() {
		return Flux.just(Customer.builder().customerId(11111).customerName("Customer A").build(), Customer.builder().customerName("Customer B").build());
	}
}
