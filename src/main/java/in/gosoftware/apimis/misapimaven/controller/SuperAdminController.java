package in.gosoftware.apimis.misapimaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import in.gosoftware.apimis.misapimaven.model.SuperAdmin;
import in.gosoftware.apimis.misapimaven.services.SuperAdminService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SuperAdminController {
	
	@Autowired
	SuperAdminService superAdminService;
	
	 @CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value ="/sudocreate", method = RequestMethod.POST)
	 @ResponseStatus(HttpStatus.CREATED)
	 @ResponseBody
	    public void create(@RequestBody SuperAdmin superAdmin) {
		 superAdminService.create(superAdmin);
	    }
	 
	    @RequestMapping(value = "/sudoid/{id}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Mono<SuperAdmin>> findById(@PathVariable("id") String id) {
	        Mono<SuperAdmin> superadmin = superAdminService.findById(id);
	        HttpStatus status = superadmin != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Mono<SuperAdmin>>(superadmin, status);
	    }
	 
	    @RequestMapping(value = "/sudoname/{name}", method = RequestMethod.GET)
	    @ResponseBody
	    public Flux<SuperAdmin> findByName(@PathVariable("name") String name) {
	        return superAdminService.findByName(name);
	    }
	 
	    @RequestMapping(value =  "/allsudo",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ResponseBody
	    public Flux<SuperAdmin> findAll() {
	        Flux<SuperAdmin> users = superAdminService.findAll();
	        return users;
	    }
	 
	    @RequestMapping(value = "/sudoupdate", method = RequestMethod.PUT)
	    @ResponseStatus(HttpStatus.OK)
	    public Mono<SuperAdmin> update(@RequestBody SuperAdmin superadmin) {
	        return superAdminService.update(superadmin);
	    }
	 
	    @RequestMapping(value = "/sudodelete/{id}", method = RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.OK)
	    public void delete(@PathVariable("id") String id) {
	    	superAdminService.delete(id).subscribe();
	    }


}
