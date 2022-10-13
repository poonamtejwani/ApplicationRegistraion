package com.example.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenAppBinding {
	
	private String fullname;
	
	private String email;
	private Long phno;
	
	private String gender;
	
	private Long ssn;
	
	private LocalDate dob;
	

}
