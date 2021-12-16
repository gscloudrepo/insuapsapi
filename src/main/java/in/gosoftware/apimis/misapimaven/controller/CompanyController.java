package in.gosoftware.apimis.misapimaven.controller;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import in.gosoftware.apimis.misapimaven.model.Company;
import in.gosoftware.apimis.misapimaven.model.User;
import in.gosoftware.apimis.misapimaven.model.UserGroup;
import in.gosoftware.apimis.misapimaven.repository.UserGroupRepository;
import in.gosoftware.apimis.misapimaven.repository.UserRepository;
import in.gosoftware.apimis.misapimaven.services.CompanyService;
import in.gosoftware.apimis.misapimaven.services.CustomUserDetailsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
 @CrossOrigin(origins = "*")

@RequestMapping("/auth/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private CustomUserDetailsService userService;
	@Autowired
	UserRepository users;
	@Autowired
	private UserGroupRepository userGroupRepository;
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/companycreate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Mono<Company> create(@RequestBody Company company) {
		String firstname = company.getName();
		String lastname = company.getLastname();
		String email = company.getEmail();
		String password = company.getPassword();
		String al1=company.getAddress();
		String city=company.getCity();
		String pcode=company.getPcode();
		String state=company.getState();
		String mob=company.getContact();
		String cid=company.getCid();
		String pin=company.getPin();
		String cmpid=company.getId();
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setAl1(al1);
		user.setCity(city);
		user.setPcode(pcode);
		user.setState(state);
		user.setMob(mob);
		user.setCid(cid);
		user.setPin(pin);
		user.setCmpid(cmpid);
		UserGroup userRoleName = userGroupRepository.findByName("ADMIN");
		user.setUserGroups(new HashSet<>(Arrays.asList(userRoleName)));
		//user.setId(users.findByEmail(email).getId());
		userService.saveUser(user);
		return companyService.create(company);

	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/updatecompany/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Company>> findById(@PathVariable("id") String id) {
		Mono<Company> company = companyService.findById(id);
		HttpStatus status = company != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Company>>(company, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getuser/{emailid}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<User> findByEmail(@PathVariable("emailid") String emailid) {
		User user = companyService.findByEmail(emailid);
		HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<User>(user, status);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getcompany/{cid}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Company>> findByCid(@PathVariable("cid") String cid) {
		Mono<Company> cmp = companyService.findByAllCid(cid);
		HttpStatus status = cmp != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Company>>(cmp, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/companyname/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Flux<Company> findByName(@PathVariable("name") String name) {
		return companyService.findByName(name);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allcompany", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<Company> findAll() {
		Flux<Company> customers = companyService.findAll();
		return customers;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/companyupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<Company> update(@RequestBody Company company) {
		String firstname = company.getName();
		String lastname = company.getLastname();
		String email = company.getEmail();
		String password = company.getPassword();
		String al1=company.getAddress();
		String city=company.getCity();
		String pcode=company.getPcode();
		String state=company.getState();
		String mob=company.getContact();
		String cid=company.getCid();
		String pin=company.getPin();
		String cmpid=company.getId();
		//String cid=company.getCid();
		User user = new User();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setAl1(al1);
		user.setCity(city);
		user.setPcode(pcode);
		user.setState(state);
		user.setMob(mob);
		user.setCid(cid);
		user.setPin(pin);
		user.setEnabled(true);
		user.setCmpid(cmpid);
		user.setId(users.findByEmail(email).getId());
		UserGroup userRoleName = userGroupRepository.findByName("ADMIN");
		user.setUserGroups(new HashSet<>(Arrays.asList(userRoleName)));
		userService.update(user);
		return companyService.update(company);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/companydelete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		companyService.delete(id).subscribe();
		users.deleteByCmpid(id);
	}
	@GetMapping("/getbyemail/{email}")
    public Mono<Boolean> getBycmpid(@PathVariable("email") String email) {
        return companyService.findUserByemailid(email);
    }
}
