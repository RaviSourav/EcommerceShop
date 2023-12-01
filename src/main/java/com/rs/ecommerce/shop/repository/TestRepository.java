package com.rs.ecommerce.shop.repository;

import com.rs.ecommerce.shop.model.Customer;
import com.rs.ecommerce.shop.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TestRepository extends JpaRepository<Test,Integer> {
}
