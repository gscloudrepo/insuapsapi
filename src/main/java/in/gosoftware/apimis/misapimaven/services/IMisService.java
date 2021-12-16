package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import in.gosoftware.apimis.misapimaven.model.DateRange;
import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.model.UploadMisFile;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMisService {

	String create(Mis mis);
    
    Mono<Mis> findById(String id);
 
    
    void createmisfile(UploadMisFile uploadMisFile);
	
	UploadMisFile updatemisfile(UploadMisFile uploadMisFile);
    void deleteFile(String id);
    Flux<Mis> findAll();
 
    Mono<Mis> update(Mis mis);
 
    void delete(String id);
    Flux<Mis> findByCreatedon(Date sdate,Date edate);
    Flux<Mis> findByPolicyexpiry(Date sdate,Date edate);
}
