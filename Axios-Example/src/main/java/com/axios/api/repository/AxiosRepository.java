package com.axios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axios.api.model.Product;
@Repository


public interface AxiosRepository extends JpaRepository<Product, Long>
{

	
	
	

}
