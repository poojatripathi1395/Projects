package com.cltech_hrms.hrms.service;

import java.util.List;

import com.cltech_hrms.hrms.model.EmployeeDetailsModel;

public interface EmployeeDetailService {
	
    public List<EmployeeDetailsModel> findAll() ;
    public EmployeeDetailsModel findById(int employeeDetailId);
    public void save(EmployeeDetailsModel theEmployee) ;
    public void deleteById(int employeeDetailId) ;


}

