package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;


import in.gosoftware.apimis.misapimaven.model.HealthMis;
import in.gosoftware.apimis.misapimaven.model.UploadHealthMisFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IHealthMisService {
	String create(HealthMis healthMis);
	  Mono<HealthMis> findById(String id);
	  
	    void createhelathmisfile(UploadHealthMisFile uploadhealthmisfile);
		
	    UploadHealthMisFile updateclaimmisfile(UploadHealthMisFile uploadHealthMisFile);
	 //   void createmisfile(UploadMisFile uploadMisFile);
		
		//UploadMisFile updatemisfile(UploadMisFile uploadMisFile);
	    Flux<HealthMis> findAll();
	 
	    Mono<HealthMis> update(HealthMis healthMis);
	 
	    void delete(String id);
	    Flux<HealthMis> findByCreatedon(Date sdate,Date edate);
	    void deleteFile(String id);
}
