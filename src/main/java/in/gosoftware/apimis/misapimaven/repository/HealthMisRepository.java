package in.gosoftware.apimis.misapimaven.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.HealthMis;
import reactor.core.publisher.Flux;

public interface HealthMisRepository extends ReactiveMongoRepository<HealthMis, String>{

	

	Flux<HealthMis> findByCreatedonBetween(Date sdate, Date edate);

}
