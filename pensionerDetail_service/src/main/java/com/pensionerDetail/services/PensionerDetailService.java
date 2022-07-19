package com.pensionerDetail.services;


import java.util.List;

import com.pensionerDetail.entities.PensionerDetail;

public interface PensionerDetailService {

    PensionerDetail getPensionerDetailByAadhaar(Long aadhaar);
	PensionerDetail savePensionerDetail(PensionerDetail pensionerDetail );
	List<PensionerDetail> getPensionersDetail();
}
