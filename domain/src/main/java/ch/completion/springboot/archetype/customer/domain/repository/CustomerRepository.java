package ch.completion.springboot.archetype.customer.domain.repository;

import ch.completion.springboot.archetype.customer.domain.aggregate.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository {

	public Mono<Customer> getCustomerById(Integer customerId);

	public Flux<Customer> getCustomerAll();
}
