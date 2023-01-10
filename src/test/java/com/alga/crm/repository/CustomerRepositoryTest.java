package com.alga.crm.repository;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.alga.crm.model.Customer;

@DataJpaTest
public class CustomerRepositoryTest {
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	@DisplayName("Id is not NULL")
	public void should_ThrowException_When_IdIsNull() {
		Customer customer = new Customer();
		customer.setId(1L);
		Assertions.assertThat(customer.getId()).isNotNull();
	}

	@Test
	@DisplayName("Find a customer by name")
	public void should_FindACustomerName_When_Requested() {
		Customer customer = new Customer();
		customer.setName("Ana");
		customer.setRegistrationDate(LocalDate.of(12, 12, 12));

		this.customerRepository.save(customer);

		Assertions.assertThat(customer.getName()).isEqualTo("Ana");
	}

	@Test
	@DisplayName("Find a customer by a registration date")
	public void should_FindACustomerRegistrationDate_When_Requested() {
		Customer customer = new Customer();
		customer.setName("AAA");
		customer.setRegistrationDate(LocalDate.of(2023, 01, 9));

		this.customerRepository.save(customer);

		Assertions.assertThat(customer.getRegistrationDate())
			.isEqualTo(LocalDate.of(2023, 01, 9));
	}

}
