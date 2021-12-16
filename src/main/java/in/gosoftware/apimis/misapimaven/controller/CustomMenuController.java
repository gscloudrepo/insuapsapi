package in.gosoftware.apimis.misapimaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.gosoftware.apimis.misapimaven.model.CustomMenu;
import in.gosoftware.apimis.misapimaven.model.UserGroup;
import in.gosoftware.apimis.misapimaven.repository.CustomMenuRepo;
import in.gosoftware.apimis.misapimaven.services.CustomMenuServ;

@RestController
//@CrossOrigin(origins = "http://18.216.98.140")
@CrossOrigin(origins = "*")
@RequestMapping("api/custmenu")
public class CustomMenuController {
	
	//@Autowired
	//CustomMenuServ customMenuServ;
	@Autowired
	CustomMenuRepo custommenurepo;
	
	 @CrossOrigin(origins = "*")
	 @RequestMapping(value ="/create", method = RequestMethod.POST)
	 @ResponseStatus(HttpStatus.CREATED)
	 @ResponseBody
	    public void create(@RequestBody CustomMenu customMenu) {
		 custommenurepo.save(customMenu);
	    }
	
	

}
