package ch.completion.springboot.archetype.customer.domain.aggregate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@JsonInclude(Include.NON_NULL)
	private Integer customerId;
	private String customerName;
}
