package com.pensionerDetail.services;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.pensionerDetail.entities.Bankdetail;
import com.pensionerDetail.entities.Pensioner;
import com.pensionerDetail.entities.PensionerDetail;
import com.pensionerDetail.repository.BankDetailRepo;
import com.pensionerDetail.repository.PensionerRepo;

@Configuration
public class InitialDataConfiguration {
	
	
	@Autowired
	private PensionerRepo pensionerRepository;
	
	@Autowired
	private BankDetailRepo bankDetailRepository;
	
	
	@Autowired
	private PensionerDetail pensionerDetail;
	
	@Autowired
	private Pensioner pensioner;
	
	@Autowired
	private Bankdetail bankdetail;
	
	@PostConstruct
	public void postConstruct() {
		
        CSVReader reader;
		
		try {
			reader = new CSVReaderBuilder(new FileReader("D:\\pensionerDetail_service\\src\\main\\resources\\pensionerDetail.csv")).
			        withSkipLines(1). 
			        build();
			List<String[]> allData = reader.readAll();
			
			for (String[] row : allData) {
                            	
                   pensionerRepository.save(FromCsv(row).getPensioner());
         		   bankDetailRepository.save(FromCsv(row).getBankdetail()); 
                               
            }
			
			
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}
	

		public PensionerDetail FromCsv(String[] csvLine) {
			
			String[] values = csvLine;
		 			
			pensioner.setAadhaar_number(Long.parseLong(values[0]));
			pensioner.setName(values[1]);		
			pensioner.setDate_of_birth(values[2]);
			pensioner.setPan(values[3]);
			pensioner.setSalaryEarned(Double.parseDouble(values[4]));
			pensioner.setAllowances(Double.parseDouble(values[5]));
			pensioner.setSelfOrFamily(values[6]);
			bankdetail.setAadhaar_number(Long.parseLong(values[0]));
			bankdetail.setAccount_number(values[8]);
			bankdetail.setBank_name(values[7]);
			bankdetail.setPublicOrprivate_bank(values[9]);			
			pensionerDetail.setPensioner(pensioner);
			pensionerDetail.setBankdetail(bankdetail);
						
			return pensionerDetail;
			
				
		}

}
