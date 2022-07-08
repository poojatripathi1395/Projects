package com.cltech_hrms.hrms.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employeedetails")
public class EmployeeDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int employeeDetailId;


    @Column
    String firstName;
    
    @Column
    String lastName;
    
    @Column
    String gender;
    
    @Column
    String email;
    
    @Column
    String alternateEmail;
    
    @Column
    String contactNo;

//    public List<AddressModel> getAddress() {
//        return address;
//    }

//    public void setAddress(List<AddressModel> address) {
//        this.address = address;
//    }

    @Column
    String DOB;  // Date DOB;
    
    
    @Column
    String alternateConatactNo;
//        List<AddressModel> address;  // Address address;
    long fk_employee_id;
}
