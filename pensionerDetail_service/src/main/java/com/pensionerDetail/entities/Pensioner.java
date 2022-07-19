package com.pensionerDetail.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "PENSIONER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pensioner {
	
	@Id
	@Column(name = "AADHAAR_NUMBER")
	//@NotNull(message = "Aadhar number should't be null")
	private Long aadhaar_number;
	@Column(name = "PENSIONER_NAME")
	//@NotBlank
	private String name;
	@Column(name = "DOB")
	@NotBlank
	private String date_of_birth;
	@Column(name = "PAN_NO")
	//@NotBlank
	private String pan;
	@Column(name = "SALARY_ERND")
	//@NotBlank
	private double salaryEarned;
	@Column(name = "ALLOWANCES")
	//@NotBlank
	private double allowances;
	@Column(name = "PENSION_TYPE")
	//@NotBlank
	private String selfOrFamily;
	
}
