package in.gosoftware.apimis.misapimaven.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.Makeproposal;

import reactor.core.publisher.Flux;

public interface MakeProposalRepo extends ReactiveMongoRepository<Makeproposal, String>{
	  Flux<Makeproposal> findByCreatedonBetween(Date sdate,Date edate);
	

}
