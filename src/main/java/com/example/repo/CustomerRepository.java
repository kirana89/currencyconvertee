package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
	public Boolean existsByEmail(String email);
	
	@Query(value="select u from Customer u where u.email='email' AND u.password='password'",nativeQuery = true)
	public boolean CheckEmailPass(String email,String password);
	 
	public Boolean existsByEmailAndPassword(String email,String password);
}
