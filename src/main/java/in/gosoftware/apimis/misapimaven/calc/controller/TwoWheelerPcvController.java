package in.gosoftware.apimis.misapimaven.calc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.gosoftware.apimis.misapimaven.calc.model.Twowheelerpcv;
import in.gosoftware.apimis.misapimaven.calc.repo.TwoWheelerPcvRepo;
import in.gosoftware.apimis.misapimaven.calc.service.TwoWheelrPcvService;
import in.gosoftware.apimis.misapimaven.model.User;

@RestController
//@CrossOrigin(origins = "http://18.216.98.140")
@CrossOrigin(origins = "*")
@RequestMapping("api/calculator")
public class TwoWheelerPcvController {
	
	@Autowired
	TwoWheelrPcvService twowheelwepcvservice;
	@Autowired
	TwoWheelerPcvRepo tworepo;
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getreportoftwowheelerpcv", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	    public String getReport(@RequestBody Twowheelerpcv twowheelerpcv) {
	       
		
		 tworepo.save(twowheelerpcv);
		 
		 String id=twowheelerpcv.getId();
		 String jrxml1=twowheelerpcv.getReport_name1();
		 String jrxml2=twowheelerpcv.getReport_name2();
		return twowheelwepcvservice.generateReport(id,jrxml1,jrxml2);
	    }

}
