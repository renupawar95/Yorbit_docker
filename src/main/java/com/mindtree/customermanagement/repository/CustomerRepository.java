package com.mindtree.customermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.customermanagement.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
