package in.gosoftware.apimis.misapimaven.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.gosoftware.apimis.misapimaven.model.UploadMisFile;


public interface UploadMisRepo extends MongoRepository<UploadMisFile, String> {

	
	
	List<UploadMisFile> findByMisid(String id);
	void deleteByMisidAndFilenametype(String cliammisid, String filenametype);
	void deleteByMisid(String id);
}
