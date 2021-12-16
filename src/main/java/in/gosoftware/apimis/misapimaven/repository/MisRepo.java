package in.gosoftware.apimis.misapimaven.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.DateRange;
import in.gosoftware.apimis.misapimaven.model.Mis;
import reactor.core.publisher.Flux;

public interface MisRepo extends ReactiveMongoRepository<Mis, String> {
    Flux<Mis> findByCreatedonBetween(Date sdate,Date edate);
    Flux<Mis> findByExpiryBetween(Date sdate,Date edate);
   

}
	