package in.gosoftware.apimis.misapimaven.services;


import in.gosoftware.apimis.misapimaven.model.Quotation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuotationService {
	
	String create(Quotation quotation);
    
    Mono<Quotation> findById(String id);

 
   
 
    Flux<Quotation> findAll();
 
    Mono<Quotation> update(Quotation quotation);
 
    void delete(String id);

}
