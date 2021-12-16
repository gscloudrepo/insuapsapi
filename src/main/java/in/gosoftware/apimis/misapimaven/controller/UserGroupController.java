package in.gosoftware.apimis.misapimaven.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import in.gosoftware.apimis.misapimaven.model.UserGroup;
import in.gosoftware.apimis.misapimaven.repository.UserGroupRepository;
import in.gosoftware.apimis.misapimaven.repository.UserRepository;
import in.gosoftware.apimis.misapimaven.services.UserGroupService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@CrossOrigin(origins = "http://18.216.98.140")
@CrossOrigin(origins = "*")
@RequestMapping("api/usergroup")
public class UserGroupController {
	
	 @Autowired
	    private UserGroupService userGroupService;
	 @Autowired
	 private UserGroupRepository usergroupRepo;
	 
	 @CrossOrigin(origins = "*")
	 @RequestMapping(value ="/ugcreate", method = RequestMethod.POST)
	 @ResponseStatus(HttpStatus.CREATED)
	 @ResponseBody
	    public void create(@RequestBody UserGroup userGroup) {
		 userGroupService.create(userGroup);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/usergid/{id}", method = RequestMethod.GET)
	    @ResponseBody
	    public Optional<UserGroup> findById(@PathVariable("id") String id) {
	     
	        return userGroupService.findById(id);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/usergname/{name}", method = RequestMethod.GET)
	    @ResponseBody
	    public UserGroup findByName(@PathVariable("name") String name) {
	        return usergroupRepo.findByName(name);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value =  "/allusergroup",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ResponseBody
	    public List<UserGroup> findAll() {
	        List<UserGroup> users = userGroupService.findAll();
	        return users;
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/usergupdate", method = RequestMethod.PUT)
	    @ResponseStatus(HttpStatus.OK)
	    public UserGroup update(@RequestBody UserGroup userGroup) {
	        return userGroupService.update(userGroup);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/usergdelete/{id}", method = RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.OK)
	    public void delete(@PathVariable("id") String id) {
	    	userGroupService.delete(id);
	    }


}
