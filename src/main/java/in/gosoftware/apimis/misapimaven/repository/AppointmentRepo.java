package in.gosoftware.apimis.misapimaven.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.Appointment;
import in.gosoftware.apimis.misapimaven.model.Mis;
import reactor.core.publisher.Flux;

public interface AppointmentRepo extends ReactiveMongoRepository<Appointment,String> {

	Flux<Appointment> findByAppodtBetween(Date sdate, Date edate);
	

}
