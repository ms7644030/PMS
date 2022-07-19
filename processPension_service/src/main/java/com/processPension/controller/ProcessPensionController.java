package com.processPension.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.processPension.entities.Bankdetail;
import com.processPension.entities.PensionDetail;
import com.processPension.entities.PensionerDetail;
import com.processPension.services.ProcessPensionService;

@RestController
@RequestMapping("/processPension")
public class ProcessPensionController {
	
	@Autowired
	private ProcessPensionService processPensionService;
	
	
	@GetMapping("/{aadhaar}")
	public PensionDetail getPensionDetail(@PathVariable Long aadhaar) {
		
		
		return this.processPensionService.getPensionDetailByAadhar(aadhaar);
		
		//return new PensionDetail(400.0,420.0);
			
	}

}
