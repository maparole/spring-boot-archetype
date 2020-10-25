package ch.completion.springboot.archetype.customer.domain.service;

import ch.completion.springboot.archetype.customer.domain.aggregate.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

	public Mono<Customer> getCustomerById(Integer customerId);

	public Flux<Customer> getCustomerAll();
}
