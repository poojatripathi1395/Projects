package com.cltech_hrms.hrms.repository;

import com.cltech_hrms.hrms.model.EmployeeDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailRepo extends JpaRepository<EmployeeDetailsModel, Integer> {

}
