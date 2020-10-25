package ch.completion.springboot.archetype.customer;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import ch.completion.springboot.archetype.customer.domain.aggregate.Customer;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * This test class and the CustomerIT class will be executed in the same cached ApplicationContext without reload since they both define equal contexts via
 * their annotations
 * 
 */
@IntegrationTest
public class CustomerContextOneBisIT {

	@LocalServerPort
	int randomServerPort;

	private RequestSpecification requestSpec;

	@BeforeEach
	public void createRequestSpecification() {
		requestSpec = new RequestSpecBuilder().setBaseUri("http://localhost").setPort(randomServerPort).build();
	}

	@Test
	public void getCustomer() {
		// when
		Response response = given().spec(requestSpec).when().get("/customer/5465").thenReturn();

		// then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK.value());
		Customer customer = response.as(Customer.class);
		assertThat(customer).isNotNull();
		assertThat(customer.getCustomerId()).isEqualTo(5465);
	}

	@Test
	public void getCustomerAll() {
		// when
		Response response = given().spec(requestSpec).when().get("/customerAll").thenReturn();

		// then
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK.value());
		List<Customer> customers = List.of(response.as(Customer[].class));
		assertThat(customers.size()).isGreaterThan(0);
	}
}
