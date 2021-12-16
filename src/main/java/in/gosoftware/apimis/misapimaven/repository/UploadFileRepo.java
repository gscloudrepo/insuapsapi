package in.gosoftware.apimis.misapimaven.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import in.gosoftware.apimis.misapimaven.model.UploadVehicleFile;
import reactor.core.publisher.Flux;


public interface UploadFileRepo  extends MongoRepository<UploadVehicleFile, String> {

	 @Query("{ 'name': ?0 }")
	    UploadVehicleFile findByName(final String name);

		 UploadVehicleFile existsByCid(String id);
		 void deleteByVid(String id);
		 List<UploadVehicleFile> findByVid(String id);
		 void deleteByVidAndFilenametype(String vid,String filenametype);
}
