package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import in.gosoftware.apimis.misapimaven.model.ClaimInfo;
import in.gosoftware.apimis.misapimaven.model.UploadClaimInfoFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClaimInfoService {
	
	String create(ClaimInfo claimInfo);
    
    Mono<ClaimInfo> findById(String id);
 
    void createclaimmisfile(UploadClaimInfoFile uploadCliaminfofile);
	
    UploadClaimInfoFile updateclaiminfofile(UploadClaimInfoFile uploadCliaminfofile);
 //   void createmisfile(UploadMisFile uploadMisFile);
	
	//UploadMisFile updatemisfile(UploadMisFile uploadMisFile);
    Flux<ClaimInfo> findAll();
 
    Mono<ClaimInfo> update(ClaimInfo claimInfo);
 
    void delete(String id);
    Flux<ClaimInfo> findByCreatedon(Date sdate,Date edate);
    void deleteFile(String id);

}
