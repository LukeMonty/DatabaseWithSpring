package com.qa.Luke.Montgomery.DatabaseWithSpring.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.Luke.Montgomery.DatabaseWithSpring.model.SpringBootDatabaseModel;

@Repository
public interface DatabaseWithSpringRepository extends JpaRepository<SpringBootDatabaseModel, Long> {

	
		
}
