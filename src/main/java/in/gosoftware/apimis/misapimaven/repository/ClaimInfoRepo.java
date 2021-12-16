package in.gosoftware.apimis.misapimaven.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.ClaimInfo;

import reactor.core.publisher.Flux;

public interface ClaimInfoRepo extends ReactiveMongoRepository<ClaimInfo, String> {
	 Flux<ClaimInfo> findByCreatedonBetween(Date sdate,Date edate);
	 
	 
}
