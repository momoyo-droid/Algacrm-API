package com.alga.crm.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alga.crm.model.Customer;
import com.alga.crm.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired /* instancia customerRepository automaticamente atraves da interface */
	private CustomerRepository customerRepository;

	/* busca todos os clientes */
	@GetMapping
	public List<Customer> listCustomer() {
		return customerRepository.findAll();
	}

	/* busca cliente por id */
	@GetMapping("/{id}")
	public Optional<Customer> searchCustomerId(@PathVariable("id") Long searchedId) {
		return customerRepository.findById(searchedId);
	}

	/* busca cliente por nome */
	@GetMapping("/name")
	public List<Customer> searchCustomerName(@RequestParam String name) {
		return customerRepository.findByName(name);
	}
	/* busca cliente por data de cadastro */
	@GetMapping("/registration-date")
	public List<Customer> searchCustomerRegistrationDate(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate registrationDate) {

		return customerRepository.findByRegistrationDate(registrationDate);
	}

	/* cadastro de clientes */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

}
