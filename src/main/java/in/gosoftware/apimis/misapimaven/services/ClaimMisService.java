package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.gosoftware.apimis.misapimaven.model.ClaimMis;
import in.gosoftware.apimis.misapimaven.model.UploadClaimMisFile;
import in.gosoftware.apimis.misapimaven.repository.ClaimMisRepo;
import in.gosoftware.apimis.misapimaven.repository.UploadClaimMisRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ClaimMisService implements IClaimMisService {

	@Autowired
	private ClaimMisRepo claimmisrepo;
	@Autowired
	private UploadClaimMisRepo uploadclaimmisrepo ;
	@Override
	public String create(ClaimMis claimMis) {
		claimmisrepo.save(claimMis).subscribe();
		
		return "created";
				
	}

	@Override
	public Mono<ClaimMis> findById(String id) {
		// TODO Auto-generated method stub
		return claimmisrepo.findById(id);
	}

	@Override
	public Flux<ClaimMis> findAll() {
		// TODO Auto-generated method stub
		return claimmisrepo.findAll();
	}

	@Override
	public Mono<ClaimMis> update(ClaimMis claimMis) {
		// TODO Auto-generated method stub
		return claimmisrepo.save(claimMis);
	}

	

	@Override
	public Flux<ClaimMis> findByCreatedon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return claimmisrepo.findByCreatedonBetween(sdate, edate);
	}

	@Override
	public void createclaimmisfile(UploadClaimMisFile uploadClaimMisFile) {

		uploadclaimmisrepo.save(uploadClaimMisFile);
		
	}

	@Override
	public void deleteFile(String id) {
		
		uploadclaimmisrepo.deleteByClaimmisid(id);
		
	}

	@Override
	public UploadClaimMisFile updateclaimmisfile(UploadClaimMisFile uploadClaimMisFile) {
		// TODO Auto-generated method stub
		return	uploadclaimmisrepo.save(uploadClaimMisFile);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		 claimmisrepo.deleteById(id).subscribe();
	
	}

	
}
