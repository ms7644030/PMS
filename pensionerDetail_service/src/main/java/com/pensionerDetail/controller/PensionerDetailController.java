package com.pensionerDetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pensionerDetail.entities.PensionerDetail;
import com.pensionerDetail.services.PensionerDetailService;

@RestController
//@CrossOrigin(origins="*")
@RequestMapping("/pensionerDetail")
public class PensionerDetailController {
	
	@Autowired
	private PensionerDetailService pensionerDetailService;
	
	
	@GetMapping("/{aadhar_number}")
	public ResponseEntity<PensionerDetail> getPensionerDetail(@PathVariable("aadhar_number") Long aadhaar_number ) {
		
		
		PensionerDetail pensionerDetail =  pensionerDetailService.getPensionerDetailByAadhaar(aadhaar_number);
		
		return new ResponseEntity<PensionerDetail>(pensionerDetail, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	 public PensionerDetail savePensionerDetail(@RequestBody PensionerDetail pensionerDetail ) {
		 
		 return pensionerDetailService.savePensionerDetail(pensionerDetail);
	 }
	
	@GetMapping("/all" )
	public ResponseEntity<List<PensionerDetail>> retrieveAllPensionerDetail() {
		
		
		List<PensionerDetail> list= pensionerDetailService.getPensionersDetail();
		
		return new ResponseEntity<List<PensionerDetail>>(list, HttpStatus.OK);
		
	}
	
	
	

}
