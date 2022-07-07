package com.cltech_hrms.hrms.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cltech_hrms.hrms.model.EmployeeDetailsModel;
import com.cltech_hrms.hrms.repository.EmployeeDetailRepo;
import com.cltech_hrms.hrms.service.EmployeeDetailService;

@Service
public class EmployeeDetailServiceImpl implements EmployeeDetailService {
    @Autowired
    private EmployeeDetailRepo employeeDetailRepo;
    private static Logger LOGGER = LogManager.getLogger(EmployeeDetailServiceImpl.class);


	 @Override
	    public List<EmployeeDetailsModel> findAll() 
	    {
		 try {
			 return employeeDetailRepo.findAll();
			
			 
		 }catch(Exception e) {
			 LOGGER.error(e.getMessage(), e);
			  return null;
		 }
		 
		 
		 
	        
	    }

	 
	    @Override
	    public EmployeeDetailsModel findById(int employeeDetailId) 
	    {
	    	Optional<EmployeeDetailsModel> findById = employeeDetailRepo.findById(employeeDetailId);
	        return findById.get();
	    }

	    @Override
	    public void save(EmployeeDetailsModel theEmployee) 
	    {
	    	employeeDetailRepo.save(theEmployee);
	    }

	    @Override
	    public void deleteById(int employeeDetailId)
	    {
	    	employeeDetailRepo.deleteById(employeeDetailId);
	    }
	
}
