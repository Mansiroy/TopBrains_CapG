package com.cg.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.entity.Employees;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employees, Integer>{
	

}