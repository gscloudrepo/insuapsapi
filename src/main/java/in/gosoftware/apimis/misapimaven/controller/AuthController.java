package in.gosoftware.apimis.misapimaven.controller;

import static org.springframework.http.ResponseEntity.ok;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.gosoftware.apimis.misapimaven.configs.JwtTokenProvider;
import in.gosoftware.apimis.misapimaven.model.Company;
import in.gosoftware.apimis.misapimaven.model.User;
import in.gosoftware.apimis.misapimaven.model.UserGroup;
import in.gosoftware.apimis.misapimaven.repository.CompanyRepo;
import in.gosoftware.apimis.misapimaven.repository.UserRepository;
import in.gosoftware.apimis.misapimaven.services.CompanyService;
import in.gosoftware.apimis.misapimaven.services.CustomUserDetailsService;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;
    @Autowired
    CompanyRepo companyRepo;
    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private CompanyService companyService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthBody data) {
    	  String username = data.getEmail();
       
    	   if(this.users.findByEmail(username).isEnabled()==false) {
    		   return new ResponseEntity<>(
    			          "User not Authorised", 
    			          HttpStatus.BAD_REQUEST);
           }
    	   else
    	   {
    	try
    	{
          
         
            // String cmpid=data.getCid();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, this.users.findByEmail(username).getUserGroups());
            String user = this.users.findByEmail(username).getFirstname();
            String mobile=this.users.findByEmail(username).getMob();
            
            Map<Object, Object> model = new HashMap<>();
            model.put("email", username);
            model.put("token", token);
            model.put("cid", this.users.findByEmail(username).getCid());
            model.put("name", user);
            model.put("mobile", mobile);
            return ok(model);
        } catch (AuthenticationException e) 
    	{
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    	   }
    }

    @SuppressWarnings("rawtypes")
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user) {
        User userExists = userService.findUserByEmail(user.getEmail());
        User cidExists = userService.findUserBycmpid(user.getCid());
        if (cidExists == null) {
            throw new BadCredentialsException("Company with companyID: " + user.getCid() + " Doe not exists");
        }
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
        }
        userService.saveUser(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }

    @GetMapping("/getbyemail/{emailid}")
    public User getByEmail(@PathVariable("emailid") String id) {
        return userService.findUserByEmail(id);
    }

    @GetMapping("/getbycid/{cmpid}")
    public Mono<Boolean> getBycmpid(@PathVariable("cmpid") String id) {
        return companyService.findUserBycmpid(id);
    }
    @GetMapping("/getbympin/{pin}/{cmpid}")
    public ResponseEntity getByPin(@PathVariable("pin") String pin,@PathVariable("cmpid") String cmpid) {
    	
    	String username=this.users.findByCidAndPin(cmpid, pin).getEmail();
    	  if(this.users.findByEmail(username).isEnabled()==false) {
   		   return new ResponseEntity<>(
   			          "User not Authorised", 
   			          HttpStatus.BAD_REQUEST);
          }
   	   else {
    	 String token = jwtTokenProvider.createToken(pin, this.users.findByPin(pin).getUserGroups());
    	 
    	 String user = this.users.findByCidAndPin(cmpid, pin).getFirstname();
         String mobile=this.users.findByCidAndPin(cmpid, pin).getMob();
         Map<Object, Object> model = new HashMap<>();
         model.put("email", username);
         model.put("token", token);
         model.put("cid", cmpid);
         model.put("name", user);
         model.put("mobile", mobile);
         return ok(model);
   	   }
        		
    }

    @PutMapping("/update")
    public User UpdateUserProfile(@RequestBody User user) {

//        Company company = new Company();
//        company.setCid(user.getCid());
//        company.setName(user.getFirstname());
//        company.setAddress(user.getAl1());
//        company.setCity(user.getCity());
//        company.setContact(user.getMob());
//        company.setState(user.getState());
//        company.setEmail(user.getEmail());
//        company.setPcode(user.getPcode());
//        company.setLastname(user.getLastname());
//        companyService.update(company);
        return userService.update(user);

        // return userService.findUserByEmail(id);
    }
}