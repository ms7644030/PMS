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
	private Pensioner pensioner;
	@Autowired
	private Bankdetail bankdetail;
	@Autowired
	private PensionerDetail pensionerDetail;
	
	
	@Override
	public PensionerDetail getPensionerDetailByAadhaar(Long aadhaar) {
		
		pensioner = pensionerRepository.findById(aadhaar).get();
		bankdetail = bankdetailRepository.findById(aadhaar).get();
		
		pensionerDetail.setPensioner(pensioner);
		pensionerDetail.setBankdetail(bankdetail);
		
		return pensionerDetail;
	}


	@Override
	public PensionerDetail savePensionerDetail(PensionerDetail pd) {
		
		   pensionerRepository.save(pd.getPensioner());
		   bankdetailRepository.save(pd.getBankdetail());
		   
		return getPensionerDetailByAadhaar(pd.getPensioner().getAadhaar_number());
	}
	
	
	@Override
	public List<PensionerDetail> getPensionersDetail() {
		
		List<Pensioner> pensioners = new ArrayList<>();
		List<PensionerDetail> pensionersDetail = new ArrayList<>();
		
		
		pensioners = pensionerRepository.findAll();
		
		for (Pensioner pn : pensioners) {
			
			bankdetail = bankdetailRepository.findById(pn.getAadhaar_number()).get();
			
			pensionerDetail.setPensioner(pn);
			pensionerDetail.setBankdetail(bankdetail);
			
			pensionersDetail.add(pensionerDetail);
						
		}
		
		return pensionersDetail;
	}
	
	

}
