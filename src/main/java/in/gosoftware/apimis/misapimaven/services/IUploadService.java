package in.gosoftware.apimis.misapimaven.services;

import java.util.List;
import java.util.Optional;

import in.gosoftware.apimis.misapimaven.model.UploadVehicleFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUploadService {
	
	
	String create(UploadVehicleFile uploadVehicleFile);
    
    Optional<UploadVehicleFile> findById(String id);
 
    UploadVehicleFile findByName(String name);
 
    List<UploadVehicleFile> findAll();
 
    UploadVehicleFile update(UploadVehicleFile uploadVehicleFile);
 
    void delete(String id);
}
