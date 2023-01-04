package com.alga.crm.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alga.crm.model.Customer;

@Repository 
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	List<Customer> findByName(String name);
	List<Customer> findByRegistrationDate(LocalDate registrationDate_);

	//List<Customer> findByRegistrationDate(String registrationDate_);
}
