package com.cltech_hrms.hrms.controller;

import java.util.List;
import java.util.Map;

import com.cltech_hrms.hrms.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import com.cltech_hrms.hrms.model.EmployeeDetailsModel;
import com.cltech_hrms.hrms.serviceimpl.EmployeeDetailServiceImpl;

import javax.net.ssl.SSLEngineResult;

@RestController
@RequestMapping(value = "/employeedetails")
public class EmployeeDetailsController {
	
    @Autowired
    EmployeeDetailServiceImpl employeeDetailService;
   @Autowired
    JdbcTemplate jdbcTemplate;
    CommonResponse response = new CommonResponse();

    @GetMapping(value = "/employees")
    public CommonResponse findAllemp()
    {
        String sql = "select * from poojadb.employeedetails e  inner join poojadb.address a where a.fk_employee_detail_id = e.fk_employee_id;";
        List<Map<String, Object>> list= jdbcTemplate.queryForList(sql);
        if(list!= null) {
            response.setStatus(SSLEngineResult.Status.OK);
            response.setMessage("successful");
            response.setResponse(list);
        }else{
            response.setStatus(SSLEngineResult.Status.BUFFER_UNDERFLOW);
            response.setMessage("Unsuccessful");
            response.setResponse(null);
        }
        return response;

    }
    
    @GetMapping (value ="/employees/{employeeId}")
    public CommonResponse getEmployee(@PathVariable("employeeId") int employeeDetailId)
    {
    System.out.println("Employee detail id  : "+employeeDetailId);

    try{
    EmployeeDetailsModel theEmployee = employeeDetailService.findById(employeeDetailId);
    System.out.println("the employee = "+theEmployee);
    if (theEmployee != null) {
        response.setStatus(SSLEngineResult.Status.OK);
        response.setMessage("successful");
        response.setResponse(theEmployee);
    } else {
        response.setStatus(SSLEngineResult.Status.BUFFER_UNDERFLOW);
        response.setMessage("Record not found");
        response.setResponse(null);
    }
    }catch(Exception e){
    response.setStatus(SSLEngineResult.Status.BUFFER_UNDERFLOW);
    response.setMessage("Provide valid id");
    response.setResponse(null);
}

        return response;
    }
    
    @PostMapping(value ="/employees")
    public CommonResponse addEmployee(@RequestBody EmployeeDetailsModel theEmployee)
    {
//        theEmployee.setEmployeeDetailId(0);
        if(theEmployee!=null) {
             theEmployee.setEmployeeDetailId(0);
             employeeDetailService.save(theEmployee);
            response.setStatus(SSLEngineResult.Status.OK);
            response.setMessage("successfully added");
            response.setResponse(theEmployee);
        }else{
            response.setStatus(SSLEngineResult.Status.BUFFER_UNDERFLOW);
            response.setMessage("Unable to insert details");
            response.setResponse(null);
        }
        return response;
    }
    
    @PutMapping(value ="/employees")
    public CommonResponse updateEmployee(@RequestBody EmployeeDetailsModel theEmployee)
    {
        if(theEmployee.getEmployeeDetailId()!=0 ) {
            employeeDetailService.save(theEmployee);
            response.setStatus(SSLEngineResult.Status.OK);
            response.setMessage("successfully updated");
            response.setResponse(theEmployee);
        }else{
            response.setStatus(SSLEngineResult.Status.BUFFER_UNDERFLOW);
            response.setMessage("please provide valid id");
            response.setResponse(null);
        }
        return response;
    }
    
    @DeleteMapping(value = "/employees/{employeeId}")
    public CommonResponse deleteEmployee(@PathVariable("employeeId") int employeeDetailId)
    {
        EmployeeDetailsModel theEmployee = employeeDetailService.findById(employeeDetailId);
        if(theEmployee.getEmployeeDetailId()!=0) {
            employeeDetailService.deleteById(employeeDetailId);
            response.setStatus(SSLEngineResult.Status.OK);
            response.setMessage("successfully deleted");
            response.setResponse(employeeDetailId);
        }else{
            response.setStatus(SSLEngineResult.Status.BUFFER_UNDERFLOW);
            response.setMessage("please provide valid id");
            response.setResponse(null);
        }
        return response;

//        if(theEmployee == null)
//        {
//            throw new RuntimeException("Employee Id not found - " + employeeDetailId);
//        }
//        employeeDetailService.deleteById(employeeDetailId);
//
//        return "Deleted Employee id - " + employeeDetailId;
    }
    
}
