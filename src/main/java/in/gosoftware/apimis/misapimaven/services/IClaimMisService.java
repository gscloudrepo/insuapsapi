package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import in.gosoftware.apimis.misapimaven.model.ClaimMis;
import in.gosoftware.apimis.misapimaven.model.UploadClaimMisFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClaimMisService {
	
String create(ClaimMis claimMis);
    
    Mono<ClaimMis> findById(String id);
 
    void createclaimmisfile(UploadClaimMisFile uploadClaimMisFile);
	
    UploadClaimMisFile updateclaimmisfile(UploadClaimMisFile uploadClaimMisFile);
 //   void createmisfile(UploadMisFile uploadMisFile);
	
	//UploadMisFile updatemisfile(UploadMisFile uploadMisFile);
    Flux<ClaimMis> findAll();
 
    Mono<ClaimMis> update(ClaimMis claimMis);
 
    void delete(String id);
    Flux<ClaimMis> findByCreatedon(Date sdate,Date edate);
    void deleteFile(String id);

}
