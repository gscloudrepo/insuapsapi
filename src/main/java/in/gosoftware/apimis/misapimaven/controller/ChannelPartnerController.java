package in.gosoftware.apimis.misapimaven.controller;

import java.util.Arrays;
import java.util.HashSet;

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

import in.gosoftware.apimis.misapimaven.model.ChannelPartner;
import in.gosoftware.apimis.misapimaven.model.User;
import in.gosoftware.apimis.misapimaven.model.UserGroup;
import in.gosoftware.apimis.misapimaven.repository.UserGroupRepository;
import in.gosoftware.apimis.misapimaven.repository.UserRepository;
import in.gosoftware.apimis.misapimaven.services.ChannelPartnetService;
import in.gosoftware.apimis.misapimaven.services.CustomUserDetailsService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@CrossOrigin(origins = "http://18.216.98.140")
@CrossOrigin(origins = "*")
@RequestMapping("api/cp")
@RestController
public class ChannelPartnerController {

	@Autowired
	ChannelPartnetService channelpartnetService;
	@Autowired
	private UserGroupRepository userGroupRepository;
	@Autowired
	UserRepository users;
	@Autowired
	private CustomUserDetailsService userService;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cpcreate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody ChannelPartner channelpartner) {
		String firstname = channelpartner.getName();
		String lastname = channelpartner.getLname();
		String email = channelpartner.getEmail();
		String password = channelpartner.getPassw();
		String al1 = channelpartner.getAdl1();
		String city = channelpartner.getCity();
		String pcode = channelpartner.getPin();
		String state = channelpartner.getState();
		String mob = channelpartner.getMobile();
		String cid = channelpartner.getCid();
		String mpin = channelpartner.getMpin();
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
		user.setPin(mpin);
		UserGroup userRoleName = userGroupRepository.findByNameAndCid(channelpartner.getPtype(),channelpartner.getCid());
		user.setUserGroups(new HashSet<>(Arrays.asList(userRoleName)));
		userService.saveUser(user);

		channelpartnetService.create(channelpartner);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<ChannelPartner>> findById(@PathVariable("id") String id) {
		Mono<ChannelPartner> customer = channelpartnetService.findById(id);
		HttpStatus status = customer != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<ChannelPartner>>(customer, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cpname/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Flux<ChannelPartner> findByName(@PathVariable("name") String name) {
		return channelpartnetService.findByName(name);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allcp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<ChannelPartner> findAll() {
		Flux<ChannelPartner> channelpartners = channelpartnetService.findAll();
		return channelpartners;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cpupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<ChannelPartner> update(@RequestBody ChannelPartner channelpartner) {

		String firstname = channelpartner.getName();
		String lastname = channelpartner.getLname();
		String email = channelpartner.getEmail();
		String password = channelpartner.getPassw();
		String al1 = channelpartner.getAdl1();
		String city = channelpartner.getCity();
		String pcode = channelpartner.getPin();
		String state = channelpartner.getState();
		String mob = channelpartner.getMobile();
		String cid = channelpartner.getCid();
		String mpin = channelpartner.getMpin();
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
		user.setPin(mpin);
		user.setId(users.findByEmail(email).getId());
		UserGroup userRoleName = userGroupRepository.findByNameAndCid(channelpartner.getPtype(),channelpartner.getCid());
		user.setUserGroups(new HashSet<>(Arrays.asList(userRoleName)));
		userService.update(user);
		return channelpartnetService.update(channelpartner);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cpdelete/{email}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("email") String email) {
		channelpartnetService.delete(email);
		userService.deleteUserByEmail(email);
		
	}

}
