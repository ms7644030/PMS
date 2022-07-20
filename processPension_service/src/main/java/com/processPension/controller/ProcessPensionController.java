package com.processPension.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.processPension.entities.PensionDetail;
import com.processPension.entities.ProcessPensionInput;
import com.processPension.services.ProcessPensionService;

@RestController
@RequestMapping("/processPension")
public class ProcessPensionController {
	
	@Autowired
	private ProcessPensionService processPensionService;
	
	
	@PostMapping("/aadhaar")
	public PensionDetail getPensionDetail(@RequestBody ProcessPensionInput processPensionInput) {
		
		
		return this.processPensionService.getPensionDetailByAadhar(processPensionInput.getAadhaar_number());
		
		
			
	}

}
