package com.rs.ecommerce.shop.repository;

import com.rs.ecommerce.shop.model.Customer;
import com.rs.ecommerce.shop.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
}
