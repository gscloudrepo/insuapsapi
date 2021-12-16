package in.gosoftware.apimis.misapimaven.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import in.gosoftware.apimis.misapimaven.model.UploadClaimMisFile;
import in.gosoftware.apimis.misapimaven.model.UploadMisFile;

public interface UploadClaimMisRepo extends MongoRepository<UploadClaimMisFile, String> {

	void deleteByClaimmisid(String claimmisid);

	List<UploadClaimMisFile> findByClaimmisid(String claimmisid);

	void deleteByClaimmisidAndFilenametype(String claimmisid, String filenametype);

}
