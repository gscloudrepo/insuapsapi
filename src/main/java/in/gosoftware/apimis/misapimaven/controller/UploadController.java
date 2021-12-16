package in.gosoftware.apimis.misapimaven.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.nio.charset.*; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import in.gosoftware.apimis.misapimaven.model.UploadVehicleFile;
import in.gosoftware.apimis.misapimaven.repository.UploadFileRepo;
import in.gosoftware.apimis.misapimaven.services.UploadService;

import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/uploadvehicledoc")
public class UploadController {
//	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	public static String uploadDirectory = "/var/www/insuaps/html/vehicle";
	@Autowired
	private UploadService uploadService;
	@Autowired
	private UploadFileRepo uploadFileRepo;
	private static final Logger logger = Logger.getLogger(UploadController.class.getName());
	String filenames = "";
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/uploadfile", headers = "Content-Type=multipart/form-data")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file,
			@RequestParam("cmpid") String cid, @RequestParam("vid") String vid,
			@RequestParam("filename") String filenametype) {

		try {
			if (file.isEmpty()) {

				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
			} else {
				String randomnumber = getAlphaNumericString(20);
				filenames = randomnumber + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
				UploadVehicleFile uploadvehiclefile = new UploadVehicleFile(cid, filenames, vid, filenametype);

				Files.write(fileNameAndPath, file.getBytes());
				uploadService.create(uploadvehiclefile);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// uploadVehicleFile.setFile(file);
		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>("Done", HttpStatus.OK);

	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/updateuploadfile", method = RequestMethod.PUT, headers = "Content-Type=multipart/form-data")
	@ResponseStatus(HttpStatus.OK)
	public UploadVehicleFile updateuploadData(@RequestParam("file") MultipartFile file,
	@RequestParam("cmpid") String cid, @RequestParam("vid") String vid,
	@RequestParam("filename") String filenametype,@RequestParam("id") String id)
	 {

		try {
			if (file.isEmpty()) {

				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
			} else {
				String randomnumber = getAlphaNumericString(20);
				filenames = randomnumber + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);

				Files.write(fileNameAndPath, file.getBytes());
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		UploadVehicleFile uploadvehiclefile = new UploadVehicleFile(id,cid, filenames, vid, filenametype);

		return uploadService.update(uploadvehiclefile);
	}


	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getallfiles/{vid}", method = RequestMethod.GET)
	@ResponseBody

	public List<UploadVehicleFile> getImage(@PathVariable("vid") String vid) {
		return uploadFileRepo.findByVid(vid);
		// UploadProposalFile img = new
		// UploadProposalFile(retrievedImage.get().getName(),
		// retrievedImage.get().getType(),
		// decompressBytes(retrievedImage.get().getPicByte()));
		// return img;
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/deletefile/{propid}/{filenametype}", method = RequestMethod.DELETE)
	@ResponseBody

	public void deleteFileByPropid(@PathVariable("propid") String propid,@PathVariable("filenametype") String filenametype) {
		 uploadFileRepo.deleteByVidAndFilenametype(propid, filenametype);
		
	}


	@CrossOrigin(origins = "*")
	@RequestMapping(value =  "/alldocs/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public UploadVehicleFile findByCid(@PathVariable("id") String id) {
	//	Flux<UploadVehicleFile> users = uploadFileRepo.findAll();
		return uploadFileRepo.existsByCid(id);
	}
	// @CrossOrigin(origins = "http://localhost:8100")
	// @RequestMapping(value ="/uploadfile", method = RequestMethod.POST)
	// @ResponseStatus(HttpStatus.CREATED)
	// @ResponseBody
	// public void create(@RequestBody UploadVehicleFile uploadVehicleFile) {
	// uploadService.create(uploadVehicleFile);
	// }

	// @CrossOrigin(origins = "http://localhost:8100")
	// @RequestMapping(value = "/usergid/{id}", method = RequestMethod.GET)
	// @ResponseBody
	// public ResponseEntity<Mono<UploadVehicleFile>> findById(@PathVariable("id")
	// String id) {
	// Mono<UploadVehicleFile> uploadFile = uploadService.findById(id);
	// HttpStatus status = uploadFile != null ? HttpStatus.OK :
	// HttpStatus.NOT_FOUND;
	// return new ResponseEntity<Mono<UploadVehicleFile>>(uploadFile, status);
	// }
	// @CrossOrigin(origins = "http://localhost:8100")
	// @RequestMapping(value = "/usergname/{name}", method = RequestMethod.GET)
	// @ResponseBody
	// public Flux<UploadVehicleFile> findByName(@PathVariable("name") String name)
	// {
	// return uploadService.findByName(name);
	// }
	// @CrossOrigin(origins = "http://localhost:8100")
	// @RequestMapping(value = "/allusergroup",method = RequestMethod.GET, produces
	// = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// @ResponseBody
	// public Flux<UploadVehicleFile> findAll() {
	// Flux<UploadVehicleFile> users = uploadService.findAll();
	// return users;
	// }
	// @CrossOrigin(origins = "http://localhost:8100")
	// @RequestMapping(value = "/usergupdate", method = RequestMethod.PUT)
	// @ResponseStatus(HttpStatus.OK)
	// public Mono<UploadVehicleFile> update(@RequestBody UploadVehicleFile
	// userGroup) {
	// return uploadService.update(userGroup);
	// }
	// @CrossOrigin(origins = "http://localhost:8100")
	// @RequestMapping(value = "/usergdelete/{id}", method = RequestMethod.DELETE)
	// @ResponseStatus(HttpStatus.OK)
	// public void delete(@PathVariable("id") String id) {
	// uploadService.delete(id).subscribe();
	// }









	//////////////////////////



	static String getAlphaNumericString(int n) 
    { 
  
        // length is bounded by 256 Character 
        byte[] array = new byte[256]; 
        new Random().nextBytes(array); 
  
        String randomString 
            = new String(array, Charset.forName("UTF-8")); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(); 
  
        // remove all spacial char 
        String  AlphaNumericString 
            = randomString 
                  .replaceAll("[^A-Za-z0-9]", ""); 
  
        // Append first 20 alphanumeric characters 
        // from the generated random String into the result 
        for (int k = 0; k < AlphaNumericString.length(); k++) { 
  
            if (Character.isLetter(AlphaNumericString.charAt(k)) 
                    && (n > 0) 
                || Character.isDigit(AlphaNumericString.charAt(k)) 
                       && (n > 0)) { 
  
                r.append(AlphaNumericString.charAt(k)); 
                n--; 
            } 
        } 
  
        // return the resultant string 
        return r.toString(); 
    } 
}
