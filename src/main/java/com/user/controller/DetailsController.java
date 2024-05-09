package com.user.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lowagie.text.DocumentException;
import com.user.entity.AdditionDetailsEntity;
import com.user.services.AdditionDetailsService;
import com.user.util.PDFGenerator;

@CrossOrigin(origins="http://localhost:4200")
@Controller
public class DetailsController {

	@Autowired
	AdditionDetailsService additionDetailsService;
	
	@GetMapping("/downloadPdf/{adminId}/{trustName}")
	public void generatePdf (HttpServletResponse response,@PathVariable("adminId") String adminId,
			@PathVariable("trustName") String trustName) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename="+trustName+" _ "+currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		
		List<AdditionDetailsEntity> studentList = additionDetailsService.getAllDataByIdSorting(adminId);
		String totalAmount=additionDetailsService.getTotalAmount(adminId);
		PDFGenerator generator = new PDFGenerator();
		generator.setTotalAmount(totalAmount);
		generator.setTrustName(trustName);
		generator.setAdditionDetailsEntityList(studentList);
		generator.generate(response);
		
	}
}
