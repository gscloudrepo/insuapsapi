package in.gosoftware.apimis.misapimaven.services;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;

import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.model.VehicleInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IVehicleInfoService {
	
	String create(VehicleInfo vehicleInfo);
    
    Mono<VehicleInfo> findById(String id);
 
    Flux<VehicleInfo> findByName(String name);
    Flux<VehicleInfo> findByCid(String cid);
    
    Flux<VehicleInfo> findAll();
 
    Mono<VehicleInfo> update(VehicleInfo vehicleInfo);
   
    void delete(String id);
    Flux<VehicleInfo> findByNidon(Date sdate,Date edate);
    Flux<VehicleInfo> findByNpdon(Date sdate,Date edate);
    Flux<VehicleInfo> findByNsdon(Date sdate,Date edate);
    Flux<VehicleInfo> findByNpucdon(Date sdate,Date edate);
    Flux<VehicleInfo> findBySldedon(Date sdate,Date edate);
    Flux<VehicleInfo> findByNfdon(Date sdate,Date edate);
    Flux<VehicleInfo> findByNcidon(Date sdate,Date edate);
    Flux<VehicleInfo> findByTruckexpon(Date sdate,Date edate);
    Flux<VehicleInfo> findByNttdon(Date sdate,Date edate);
}
