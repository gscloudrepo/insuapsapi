package in.gosoftware.apimis.misapimaven.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gosoftware.apimis.misapimaven.model.UploadVehicleFile;
import in.gosoftware.apimis.misapimaven.repository.UploadFileRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UploadService implements IUploadService {

	@Autowired
	UploadFileRepo uploadFileRepo;

	@Override
	public String create(UploadVehicleFile uploadVehicleFile) {
		uploadFileRepo.save(uploadVehicleFile);

		return "user created";
	}

	@Override
	public Optional<UploadVehicleFile> findById(String id) {
		// TODO Auto-generated method stub
		return uploadFileRepo.findById(id);
	}

	@Override
	public UploadVehicleFile findByName(String name) {
		// TODO Auto-generated method stub
		return uploadFileRepo.findByName(name);
	}

	@Override
	public List<UploadVehicleFile> findAll() {

		return uploadFileRepo.findAll();
	}

	@Override
	public UploadVehicleFile update(UploadVehicleFile uploadVehicleFile) {

		return uploadFileRepo.save(uploadVehicleFile);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		uploadFileRepo.deleteById(id);
	}

	public void deleteFile(String id) {

		uploadFileRepo.deleteByVid(id);
	}

}
