package in.gosoftware.apimis.misapimaven.controller;

import javax.validation.Valid;

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

import in.gosoftware.apimis.misapimaven.model.Customer;
import in.gosoftware.apimis.misapimaven.services.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*")
@RequestMapping("api/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customercreate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody Customer customer) {
		customerService.create(customer);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Customer>> findById(@PathVariable("id") String id) {
		Mono<Customer> customer = customerService.findById(id);
		HttpStatus status = customer != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Customer>>(customer, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customercid/{cid}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Customer>> findByCid(@PathVariable("cid") String cid) {
		Mono<Customer> customer = customerService.findByCid(cid);
		HttpStatus status = customer != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Customer>>(customer, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customername/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Flux<Customer> findByName(@PathVariable("name") String name) {
		return customerService.findByName(name);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allcustomer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<Customer> findAll() {
		Flux<Customer> customers = customerService.findAll();
		return customers;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customerupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<Customer> update(@RequestBody Customer customer) {
		return customerService.update(customer);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/customerdelete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		customerService.delete(id).subscribe();
	}

}
