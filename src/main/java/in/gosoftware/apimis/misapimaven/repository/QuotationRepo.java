package in.gosoftware.apimis.misapimaven.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import in.gosoftware.apimis.misapimaven.model.Quotation;
import reactor.core.publisher.Flux;

public interface QuotationRepo extends ReactiveMongoRepository<Quotation, String> {
	 Flux<Quotation> findByCreatedonBetween(Date sdate,Date edate);
	
}
