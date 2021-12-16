package in.gosoftware.apimis.misapimaven.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.gosoftware.apimis.misapimaven.model.Customer;
import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.model.VehicleInfo;
import in.gosoftware.apimis.misapimaven.repository.CustomerRepo;
import in.gosoftware.apimis.misapimaven.repository.VehicleInfoRepo;
import in.gosoftware.apimis.misapimaven.services.UploadService;
import in.gosoftware.apimis.misapimaven.services.VehicleInfoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@CrossOrigin(origins = "http://18.216.98.140")
@CrossOrigin(origins = "*")
@RequestMapping("api/vehicle")
public class VehicleInfoController {

	 @Autowired
	    private VehicleInfoService vehicleInfoService;
	 @Autowired
	 private CustomerRepo customerRepo;
	 @Autowired
	 private VehicleInfoRepo vehiclerepo;
	 @Autowired
	 private UploadService uploadService;
//	 @CrossOrigin(origins = "http://localhost:8100")
//	 @RequestMapping(value ="/vehiclecreate", method = RequestMethod.POST)
//	 @ResponseStatus(HttpStatus.CREATED)
//	 @ResponseBody
//	 public void  create(@RequestParam("insfile") MultipartFile file,@RequestParam("vehicle") String vehicle) throws IOException{
//		 
//		 
//		 VehicleInfo vehicleinfo=new ObjectMapper().readValue(vehicle,VehicleInfo.class);
//		 vehicleinfo.setInsfileName(file.getOriginalFilename());
//		 vehicleinfo.setInsfile(file.getBytes());
//		 vehicleInfoService.create(vehicleinfo);
//		 
//		
//	 }
	 @CrossOrigin(origins = "*")
//	 @CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value ="/vehiclecreate", method = RequestMethod.POST)
	 @ResponseStatus(HttpStatus.CREATED)
	 @ResponseBody
	    public void create(@RequestBody VehicleInfo vehicleInfo) {
		 
		
		 vehicleInfoService.create(vehicleInfo);
	    }
	 @CrossOrigin(origins = "*")
//	 @CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value ="/vehiclecreate/all", method = RequestMethod.POST)
	 @ResponseStatus(HttpStatus.CREATED)
	 @ResponseBody
	    public Flux<VehicleInfo> createAll(@RequestBody ArrayList<VehicleInfo> vehicleInfo) {
		 
		return  vehiclerepo.saveAll(vehicleInfo);
		// vehicleInfoService.create(vehicleInfo);
	    }
	 @CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost")
	    @RequestMapping(value = "/vehicle/{id}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Mono<VehicleInfo>> findById(@PathVariable("id") String id) {
	        Mono<VehicleInfo> vehicle = vehicleInfoService.findById(id);
	        HttpStatus status = vehicle != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Mono<VehicleInfo>>(vehicle, status);
	    }
	 @CrossOrigin(origins = "*")
	// @CrossOrigin(origins = "http://localhost:8100")
	    @RequestMapping(value = "/vehiclename/{name}", method = RequestMethod.GET)
	    @ResponseBody
	    public Flux<VehicleInfo> findByName(@PathVariable("name") String name) {
	        return vehicleInfoService.findByName(name);
	    }
	 @CrossOrigin(origins = "*")
	 //@CrossOrigin(origins = "http://localhost:8100")
	    @RequestMapping(value =  "/allvehicle",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 	//@Cacheable("vehicle-cache")
	 	
	 //@Cacheable("allvehicles")
	    @ResponseBody
	    public Flux<VehicleInfo> findAll() {
	        Flux<VehicleInfo> vehicles = vehicleInfoService.findAll();
	        return vehicles;
	    }
	 @CrossOrigin(origins = "*")
//	 @CrossOrigin(origins = "http://localhost:8100")
	    @RequestMapping(value = "/vehicleupdate", method = RequestMethod.PUT)
	    @ResponseStatus(HttpStatus.OK)
	    public Mono<VehicleInfo> update(@RequestBody VehicleInfo vehicle) {
	        return vehicleInfoService.update(vehicle);
	    }
	 @CrossOrigin(origins = "*")
//	 @CrossOrigin(origins = "http://localhost:8100")
	    @RequestMapping(value = "/vehicledelete/{id}", method = RequestMethod.DELETE)
	
	// @CacheEvict("vehicle-cache")
	    @ResponseStatus(HttpStatus.OK)
	    public void delete(@PathVariable("id") String id) {
			vehicleInfoService.delete(id);
			uploadService.deleteFile(id);
	    }
	 @CrossOrigin(origins = "*")
//	 @CrossOrigin(origins = "http://localhost:8100")
	    @RequestMapping(value = "/vehiclecid/{cid}", method = RequestMethod.GET)
	    @ResponseBody
	    public Flux<VehicleInfo> findByCid(@PathVariable("cid") String cid) {
	        return vehicleInfoService.findByCid(cid);
		}
		
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/allinswithdate/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithInsDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findByNidon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }	
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/allsldexpdate/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithSldexpDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findBySldedon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }	
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/allfitdate/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithAllfitDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findByNfdon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }	
	
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/allpermitdatee/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithAllPermitDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findByNpdon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }	
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/alltruckdate/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithAlltruckExpDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findByTruckexpon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }
	    @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/allservicedate/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithAllServiceDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findByNsdon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }
	    @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/allpucdate/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithAllPucDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findByNpucdon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }
	    @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/allgpsdate/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithGpsDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findByNcidon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }
	 @CrossOrigin(origins = "*")
	    @RequestMapping(value = "/allttdate/{sdate}/{edate}", method = RequestMethod.GET)
	    @ResponseBody
	    public ResponseEntity<Flux<VehicleInfo>> findAllWithTaxDate(@PathVariable("sdate") String sadte,@PathVariable("edate") String edate) throws ParseException {
			Date sdates=new SimpleDateFormat("yyyy-MM-dd").parse(sadte);  
			Date edates=new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			Flux<VehicleInfo> vehicleinfo = vehicleInfoService.findByNttdon(sdates, edates);
	        HttpStatus status = vehicleinfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	        return new ResponseEntity<Flux<VehicleInfo>>(vehicleinfo, status);
	    }
	 
	 @CrossOrigin(origins = "*")
//	 @CrossOrigin(origins = "http://localhost:8100")
	 @PostMapping(value = "/vehiclecreateall", headers = "Content-Type=multipart/form-data")
	 @ResponseStatus(HttpStatus.CREATED)
	 @ResponseBody
	    public void createBulk(@RequestParam("file") MultipartFile file) throws IOException {
		 
		
		InputStream inputStream=file.getInputStream();
		ObjectMapper objectMapper=new ObjectMapper();
		List<VehicleInfo> vehiclearr=Arrays.asList(objectMapper.readValue(inputStream, VehicleInfo[].class));
		if(vehiclearr!=null && vehiclearr.size()>0) {
			for(VehicleInfo vehicleInfo:vehiclearr) {
				vehiclerepo.save(vehicleInfo);
			}
		}
	    }
}
