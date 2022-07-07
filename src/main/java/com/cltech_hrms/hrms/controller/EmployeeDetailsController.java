package com.cltech_hrms.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cltech_hrms.hrms.model.EmployeeDetailsModel;
import com.cltech_hrms.hrms.serviceimpl.EmployeeDetailServiceImpl;

@RestController
@RequestMapping(value = "/employeedetails")
public class EmployeeDetailsController {
	
    @Autowired
    EmployeeDetailServiceImpl employeeDetailService;
   
    
    @GetMapping(value = "/employees")
    public List<EmployeeDetailsModel> findAllemp()
    {
        return employeeDetailService.findAll();
    }
    
    @GetMapping (value ="/employees/{employeeId}")
    public EmployeeDetailsModel getEmployee(@PathVariable("employeeId") int employeeDetailId)
    {
    	EmployeeDetailsModel theEmployee = employeeDetailService.findById(employeeDetailId);
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee Id not found - " + employeeDetailId);
        }
        return theEmployee;
    }
    
    @PostMapping(value ="/employees")
    public EmployeeDetailsModel addEmployee(@RequestBody EmployeeDetailsModel theEmployee)
    {
        theEmployee.setEmployeeDetailId(0);
        employeeDetailService.save(theEmployee);
        return theEmployee;
    }
    
    @PutMapping(value ="/employees")
    public EmployeeDetailsModel updateEmployee(@RequestBody EmployeeDetailsModel theEmployee)
    {
    	employeeDetailService.save(theEmployee);
        return theEmployee;
    }
    
    @DeleteMapping(value = "/employees/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int employeeDetailId)
    {
    	EmployeeDetailsModel theEmployee = employeeDetailService.findById(employeeDetailId);
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee Id not found - " + employeeDetailId);
        }
        employeeDetailService.deleteById(employeeDetailId);
        return "Deleted Employee id - " + employeeDetailId;
    }
    
}