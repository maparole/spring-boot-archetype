package ch.completion.springboot.archetype.customer.service.implementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ch.completion.springboot.archetype.customer.domain.aggregate.Customer;
import ch.completion.springboot.archetype.customer.domain.repository.CustomerRepository;
import reactor.core.publisher.Flux;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl service;

	@Test
	public void getCustomerById() {
		// given
		Flux<Customer> expected = Flux.just(Customer.builder().customerId(132).build());
		when(customerRepository.getCustomerAll()).thenReturn(expected);

		// when
		Flux<Customer> result = service.getCustomerAll();

		// then
		assertThat(result).isEqualTo(expected);
	}
}
