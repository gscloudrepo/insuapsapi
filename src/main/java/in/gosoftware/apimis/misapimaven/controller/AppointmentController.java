package in.gosoftware.apimis.misapimaven.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import in.gosoftware.apimis.misapimaven.model.Appointment;
import in.gosoftware.apimis.misapimaven.model.Customer;
import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.services.AppointmentService;
import in.gosoftware.apimis.misapimaven.services.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*")
@RequestMapping("api/appoinment")
public class AppointmentController {

	
	 @Autowired
	    private AppointmentService appointmentService;
	 
	 @CrossOrigin(origins = "*")
	 @RequestMapping(value ="/appcreate", method = RequestMethod.POST)
	 @ResponseStatus(HttpStatus.CREATED)
	 @ResponseBody
	    public void create(@RequestBody Appointment appointment) {
		 appointmentService.create(appointment);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/app/{id}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Mono<Appointment>> findById(@PathVariable("id") String id) {
	        Mono<Appointment> appointment = appointmentService.findById(id);
	        HttpStatus status = appointment != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Mono<Appointment>>(appointment, status);
	    }
	
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value =  "/allapp",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	    @ResponseBody
	    public Flux<Appointment> findAll() {
	        Flux<Appointment> appointment = appointmentService.findAll();
	        return appointment;
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/appupdate", method = RequestMethod.PUT)
	    @ResponseStatus(HttpStatus.OK)
	    public Mono<Appointment> update(@RequestBody Appointment appointment) {
	        return appointmentService.update(appointment);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/appdelete/{id}", method = RequestMethod.DELETE)
	    @ResponseStatus(HttpStatus.OK)
	    public void delete(@PathVariable("id") String id) {
		 appointmentService.delete(id);
	    }
	
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/appdatebetween/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<Appointment>> findAllWithDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<Appointment> appoint = appointmentService.findByAppodt(sdates,edates);
	        HttpStatus status = appoint != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<Appointment>>(appoint, status);
	    }
	
}
