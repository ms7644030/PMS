package com.pensionerDetail.services;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pensionerDetail.entities.Bankdetail;
import com.pensionerDetail.entities.Pensioner;
import com.pensionerDetail.entities.PensionerDetail;
import com.pensionerDetail.repository.BankDetailRepo;
import com.pensionerDetail.repository.PensionerRepo;

@Service
public class PensionerDetailServiceImpl implements PensionerDetailService {
	
	
	@Autowired
	private PensionerRepo pensionerRepository;
	@Autowired
	private BankDetailRepo bankdetailRepository;
	
	@Autowired
	private PensionerDetail pensionerDetail;
	
	
	@Override
	public PensionerDetail getPensionerDetailByAadhaar(Long aadhaar) {
		
		Pensioner pensioner = pensionerRepository.findById(aadhaar).get();
		Bankdetail bankdetail = bankdetailRepository.findById(aadhaar).get();
		
		pensionerDetail.setPensioner(pensioner);
		pensionerDetail.setBankdetail(bankdetail);
		
		return pensionerDetail;
	}


	@Override
	public PensionerDetail savePensionerDetail(PensionerDetail pd) {
		
		  Pensioner pensioner =  pensionerRepository.save(pd.getPensioner());
		  Bankdetail bankdetail = bankdetailRepository.save(pd.getBankdetail());
		   
		   pensionerDetail.setPensioner(pensioner);
		   pensionerDetail.setBankdetail(bankdetail);
		   
		   return pensionerDetail;
	}
	
	
	@Override
	public List<PensionerDetail> getPensionersDetail() {
		
		List<Pensioner> pensioners = new ArrayList<>();
		List<PensionerDetail> pensionersDetail = new ArrayList<>();
		
		
		pensioners = pensionerRepository.findAll();
		
		for (Pensioner pn : pensioners) {
			
			Bankdetail bankdetail = bankdetailRepository.findById(pn.getAadhaar_number()).get();
			PensionerDetail pd = new PensionerDetail();
			
			pd.setPensioner(pn);
			pd.setBankdetail(bankdetail);
			
			pensionersDetail.add(pd);
						
		}
		
		return pensionersDetail;
	}
	
	

}
