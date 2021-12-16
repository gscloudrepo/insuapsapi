package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.Appointment;
import in.gosoftware.apimis.misapimaven.model.Customer;
import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.repository.AppointmentRepo;
import in.gosoftware.apimis.misapimaven.repository.CustomerRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AppointmentService implements IAppointmentService {
	
	
	 @Autowired
	    AppointmentRepo appointmentRepo;

	@Override
	public String create(Appointment app) {
		
		appointmentRepo.save(app).subscribe();
		// TODO Auto-generated method stub
		return "app created";
				
	}

	@Override
	public Mono<Appointment> findById(String id) {
		// TODO Auto-generated method stub
		return appointmentRepo.findById(id);
	}

//	@Override
//	public Flux<Appointment> findByName(String name) {
//		// TODO Auto-generated method stub
//		return appointmentRepo.;
//	}

	@Override
	public Flux<Appointment> findAll() {
		// TODO Auto-generated method stub
		return appointmentRepo.findAll();
	}

	@Override
	public Mono<Appointment> update(Appointment app) {
		// TODO Auto-generated method stub
		return appointmentRepo.save(app);
	}

	@Override
	public  void  delete(String id) {
		// TODO Auto-generated method stub
		 appointmentRepo.deleteById(id);
	}

	@Override
	public Flux<Appointment> findByAppodt(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return appointmentRepo.findByAppodtBetween(sdate,edate);
	}



//	@Override
//	public Mono<Appointment> findById(String id) {
//		// TODO Auto-generated method stub
//		return appointmentRepo.findById(id);
//	}
//
//	@Override
//	public Flux<Customer> findByName(String name) {
//		// TODO Auto-generated method stub
//		  return customerRepo.findByName(name);
//	}
//
//	@Override
//	public Flux<Customer> findAll() {
//
//		return customerRepo.findAll();
//	}
//
//	@Override
//	public Mono<Customer> update(Customer userGroup) {
//		
//		 return customerRepo.save(userGroup);
//	}
//
//	@Override
//	public Mono<Void> delete(String id) {
//		// TODO Auto-generated method stub
//		return customerRepo.deleteById(id);
//	}
//
//	
//	@Override
//	public String create(Customer userGroup) {
//		
//		customerRepo.save(userGroup).subscribe();
//		
//		return "user created";
//	}

}
