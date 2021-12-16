package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.DateRange;
import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.model.UploadMisFile;
import in.gosoftware.apimis.misapimaven.repository.MisRepo;
import in.gosoftware.apimis.misapimaven.repository.UploadMisRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MisService implements IMisService {

	@Autowired
	MisRepo misrepo;
	@Autowired
	UploadMisRepo uploadmisrepo;

	@Override
	public String create(Mis mis) {
		// TODO Auto-generated method stub
		
				misrepo.save(mis).subscribe();
				return "created";
	}

	@Override
	public Mono<Mis> findById(String id) {
		// TODO Auto-generated method stub
		return misrepo.findById(id);
	}

	

	@Override
	public Flux<Mis> findAll() {
		// TODO Auto-generated method stub
		return misrepo.findAll();
	}

	@Override
	public Mono<Mis> update(Mis mis) {
		// TODO Auto-generated method stub
		return misrepo.save(mis);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		 misrepo.deleteById(id).subscribe();
	}

	
	
	@Override
	public Flux<Mis> findByCreatedon(Date sdate,Date edate) {
		// TODO Auto-generated method stub
		return misrepo.findByCreatedonBetween(sdate,edate);
	}

	@Override
	public void createmisfile(UploadMisFile uploadMisFile) {
		
		uploadmisrepo.save(uploadMisFile);
	}

	@Override
	public UploadMisFile updatemisfile(UploadMisFile uploadMisFile) {
		return	uploadmisrepo.save(uploadMisFile);
		
	}
	@Override
	public void deleteFile(String id) {
		uploadmisrepo.deleteByMisid(id);
	}

	@Override
	public Flux<Mis> findByPolicyexpiry(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return misrepo.findByExpiryBetween(sdate,edate);
	}
}
