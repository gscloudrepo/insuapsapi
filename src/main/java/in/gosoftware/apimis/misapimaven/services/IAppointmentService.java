package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import in.gosoftware.apimis.misapimaven.model.Appointment;
import in.gosoftware.apimis.misapimaven.model.Customer;
import in.gosoftware.apimis.misapimaven.model.Mis;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAppointmentService {

	
String create(Appointment app);
    
    Mono<Appointment> findById(String id);
 
    
    Flux<Appointment> findByAppodt(Date sdate,Date edate);
    Flux<Appointment> findAll();
 
    Mono<Appointment> update(Appointment app);
 
    void  delete(String id);
}
