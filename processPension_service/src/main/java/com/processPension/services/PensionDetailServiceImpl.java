package com.processPension.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.processPension.entities.Bankdetail;
import com.processPension.entities.PensionDetail;
import com.processPension.entities.PensionerDetail;

@Service
public class PensionDetailServiceImpl implements ProcessPensionService{
		
	@Autowired
	private RestTemplate  restTemplate;
	@Autowired
	private PensionDetail pensionDetail ;
	

	@Override
	public PensionDetail getPensionDetailByAadhar(Long aadhaar) {
		
	
		/*PensionerDetail pensionerDetail=  restTemplate.exchange("http://PENSIONER-DETAIL-SERVICE/pensionerDetail/"+aadhaar,
				HttpMethod.GET,null, PensionerDetail.class).getBody();*/
		ResponseEntity<PensionerDetail> response = restTemplate.getForEntity("http://PENSIONER-DETAIL-SERVICE/pensionerDetail/"+aadhaar,PensionerDetail.class);
			
		        PensionerDetail pensionerDetail = response.getBody();
		        
				String type = pensionerDetail.getPensioner().getSelfOrFamily();
				
				
				double lastEarnedSalary = pensionerDetail.getPensioner().getSalaryEarned();
				double allowances = pensionerDetail.getPensioner().getAllowances();
				
				Bankdetail bankdetail = pensionerDetail.getBankdetail();
				String bankType = bankdetail.getPublicOrprivate_bank(); 
				
				if (type.equalsIgnoreCase("self")) {
					
					double pensionAmmount = (0.80*lastEarnedSalary)+allowances;
					
					pensionDetail.setPensionAmount(pensionAmmount);
						
				}
				else if (type.equalsIgnoreCase("family")) {
							
							double pensionAmmount = (0.50*lastEarnedSalary)+allowances;
							
							pensionDetail.setPensionAmount(pensionAmmount);
								
				}
				
				if (bankType.equalsIgnoreCase("public")) {
					
					pensionDetail.setBankServiceCharge(500.0);
					
				}
				
				else if (bankType.equalsIgnoreCase("private")) {
							
							pensionDetail.setBankServiceCharge(550.0);
							
				}
				
				
				return pensionDetail;
				
				
	}

}
