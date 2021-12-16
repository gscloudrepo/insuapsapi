package in.gosoftware.apimis.misapimaven.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.UploadHealthMisFile;

public interface UploadHealthMisFileRepo extends MongoRepository<UploadHealthMisFile, String>{

	List<UploadHealthMisFile> findByHealthmisid(String healthmisid);

	void deleteByHealthmisidAndFilenametype(String healthmisid, String filenametype);

	void deleteByHealthmisid(String helathmisid);

}
