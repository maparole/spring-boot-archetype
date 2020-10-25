package ch.completion.springboot.archetype.customer.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.completion.springboot.archetype.customer.domain.aggregate.Customer;
import ch.completion.springboot.archetype.customer.domain.repository.CustomerRepository;
import ch.completion.springboot.archetype.customer.domain.service.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Mono<Customer> getCustomerById(Integer customerId) {
		logger.info("Inside CustomerServiceImpl getCustomerById........");
		return customerRepository.getCustomerById(customerId);
	}

	@Override
	public Flux<Customer> getCustomerAll() {
		logger.info("Inside CustomerServiceImpl getCustomerAll........");
		return customerRepository.getCustomerAll();
	}
}
