package in.gosoftware.apimis.misapimaven.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.ClaimMis;

import reactor.core.publisher.Flux;

public interface ClaimMisRepo extends ReactiveMongoRepository<ClaimMis, String> {
	  Flux<ClaimMis> findByCreatedonBetween(Date sdate,Date edate);
}
