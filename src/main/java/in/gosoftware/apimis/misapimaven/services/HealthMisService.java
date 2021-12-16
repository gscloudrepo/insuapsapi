package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import in.gosoftware.apimis.misapimaven.model.HealthMis;
import in.gosoftware.apimis.misapimaven.model.UploadHealthMisFile;
import in.gosoftware.apimis.misapimaven.repository.HealthMisRepository;
import in.gosoftware.apimis.misapimaven.repository.UploadHealthMisFileRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HealthMisService implements IHealthMisService {

	@Autowired
	private HealthMisRepository healthMisRepo;
	@Autowired
	private UploadHealthMisFileRepo uploadhealthmisfilerepo;
	@Override
	public Mono<HealthMis> findById(String id) {
		// TODO Auto-generated method stub
		return healthMisRepo.findById(id);
	}

	@Override
	public void createhelathmisfile(UploadHealthMisFile uploadhealthmisfile) {
		// TODO Auto-generated method stub
		uploadhealthmisfilerepo.save(uploadhealthmisfile);
	}

	@Override
	public UploadHealthMisFile updateclaimmisfile(UploadHealthMisFile uploadHealthMisFile) {
		// TODO Auto-generated method stub
		return uploadhealthmisfilerepo.save(uploadHealthMisFile);
	}

	@Override
	public Flux<HealthMis> findAll() {
		// TODO Auto-generated method stub
		return healthMisRepo.findAll();
	}

	@Override
	public Mono<HealthMis> update(HealthMis healthMis) {
		// TODO Auto-generated method stub
		return healthMisRepo.save(healthMis);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		healthMisRepo.deleteById(id).subscribe();
	}

	@Override
	public Flux<HealthMis> findByCreatedon(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return healthMisRepo.findByCreatedonBetween(sdate, edate);
	}

	@Override
	public void deleteFile(String helathmisid) {
		uploadhealthmisfilerepo.deleteByHealthmisid(helathmisid);
	}

	@Override
	public String create(HealthMis healthMis) {
		healthMisRepo.save(healthMis).subscribe();
		// TODO Auto-generated method stub
		return "created";
				
	}

}
