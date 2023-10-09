package com.rs.ecommerce.shop.repository;

import com.rs.ecommerce.shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
