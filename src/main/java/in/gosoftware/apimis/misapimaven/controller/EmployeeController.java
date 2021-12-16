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

import in.gosoftware.apimis.misapimaven.model.Employee;
import in.gosoftware.apimis.misapimaven.services.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@CrossOrigin(origins = "http://localhost")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*")
@RequestMapping("api/employee")
public class EmployeeController {
	
	 @Autowired
	    private EmployeeService employeeService;
	 
	 @CrossOrigin(origins = "*")
	 @RequestMapping(value ="/drivercreate", method = RequestMethod.POST)
	 @ResponseStatus(HttpStatus.CREATED)
	 @ResponseBody
	    public void create(@RequestBody Employee employee) {
		 employeeService.create(employee);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/driver/{id}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") String id) {
	        Mono<Employee> customer = employeeService.findById(id);
	        HttpStatus status = customer != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Mono<Employee>>(customer, status);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/drivername/{name}", method = RequestMethod.GET)
	    @ResponseBody
	    public Flux<Employee> findByName(@PathVariable("name") String name) {
	        return employeeService.findByName(name);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value =  "/alldriver",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ResponseBody
	    public Flux<Employee> findAll() {
	        Flux<Employee> employees = employeeService.findAll();
	        return employees;
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/driverupdate", method = RequestMethod.PUT)
	    @ResponseStatus(HttpStatus.OK)
	    public Mono<Employee> update(@RequestBody Employee customer) {
	        return employeeService.update(customer);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/driverdelete/{id}", method = RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.OK)
	    public void delete(@PathVariable("id") String id) {
	    	employeeService.delete(id).subscribe();
	    }

}
