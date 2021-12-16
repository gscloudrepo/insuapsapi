package in.gosoftware.apimis.misapimaven.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

import in.gosoftware.apimis.misapimaven.model.HealthMis;
import in.gosoftware.apimis.misapimaven.model.UploadHealthMisFile;
import in.gosoftware.apimis.misapimaven.repository.UploadHealthMisFileRepo;
import in.gosoftware.apimis.misapimaven.services.HealthMisService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "*")
@RequestMapping("api/healthmis")
public class HealthMisController {
	
	
	@Autowired
	private HealthMisService healthmiservice;
	@Autowired
	private UploadHealthMisFileRepo uploadHealthMisFileRepo;
	

	 public static String uploadDirectory = "/var/www/insuaps/html/health";
	//public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	String filenames = "";
	

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/uploadfile", headers = "Content-Type=multipart/form-data")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file,
			@RequestParam("cmpid") String cid, @RequestParam("healthmisid") String healthmisid,
			@RequestParam("filename") String filenametype) {

		try {
			if (file.isEmpty()) {

				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
			} else {
				String randomnumber = getAlphaNumericString(20);
				filenames = randomnumber + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
				UploadHealthMisFile uploadhealthmisfile = new UploadHealthMisFile(cid, filenames, healthmisid, filenametype);

				Files.write(fileNameAndPath, file.getBytes());
				healthmiservice.createhelathmisfile(uploadhealthmisfile);
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
	public UploadHealthMisFile updateuploadData(@RequestParam("file") MultipartFile file,
	@RequestParam("cmpid") String cid, @RequestParam("healthmisid") String healthmisid,
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
		UploadHealthMisFile uploadHealthMisFile = new UploadHealthMisFile(id,cid, filenames, healthmisid, filenametype);

		return healthmiservice.updateclaimmisfile(uploadHealthMisFile);
	}



	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/hmiscreate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody HealthMis healthmis) {
		healthmiservice.create(healthmis);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/hmis/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<HealthMis>> findById(@PathVariable("id") String id) {
		Mono<HealthMis> healthmis = healthmiservice.findById(id);
		HttpStatus status = healthmis != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<HealthMis>>(healthmis, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allhmis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<HealthMis> findAll() {
		Flux<HealthMis> healthmis = healthmiservice.findAll();
		return healthmis;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/hmisupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<HealthMis> update(@RequestBody HealthMis healthmis) {
		return healthmiservice.update(healthmis);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/hmisdelete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		healthmiservice.delete(id);
		healthmiservice.deleteFile(id);
	}

	// @CrossOrigin(origins = "*")
	// @RequestMapping(value = "/allmiswithdate",method = RequestMethod.GET,
	// produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	// @ResponseBody
	// public Flux<Mis> findAllWithDate(@RequestBody DateRange daterange) {
	// Flux<Mis> mis = misService.findByCreatedon(daterange);
	// return mis;
	// }
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allhmiswithdate/{sdate}/{edate}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Flux<HealthMis>> findAllWithDate(@PathVariable("sdate") String sadte,
			@PathVariable("edate") String edate) throws ParseException {
		Date sdates = new SimpleDateFormat("yyyy-MM-dd").parse(sadte);
		Date edates = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		Flux<HealthMis> healthmis = healthmiservice.findByCreatedon(sdates, edates);
		HttpStatus status = healthmis != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Flux<HealthMis>>(healthmis, status);
	}


	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getallfiles/{healthmisid}", method = RequestMethod.GET)
	@ResponseBody

	public List<UploadHealthMisFile> getImage(@PathVariable("healthmisid") String healthmisid) {
		return uploadHealthMisFileRepo.findByHealthmisid(healthmisid);
		// UploadProposalFile img = new
		// UploadProposalFile(retrievedImage.get().getName(),
		// retrievedImage.get().getType(),
		// decompressBytes(retrievedImage.get().getPicByte()));
		// return img;
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/deletefile/{healthmisid}/{filenametype}", method = RequestMethod.DELETE)
	@ResponseBody

	public void deleteFileByMisid(@PathVariable("healthmisid") String healthmisid,@PathVariable("filenametype") String filenametype) {
		uploadHealthMisFileRepo.deleteByHealthmisidAndFilenametype(healthmisid,filenametype);
		
	}

	static String getAlphaNumericString(int n) {

		// length is bounded by 256 Character
		byte[] array = new byte[256];
		new Random().nextBytes(array);

		String randomString = new String(array, Charset.forName("UTF-8"));

		// Create a StringBuffer to store the result
		StringBuffer r = new StringBuffer();

		// remove all spacial char
		String AlphaNumericString = randomString.replaceAll("[^A-Za-z0-9]", "");

		// Append first 20 alphanumeric characters
		// from the generated random String into the result
		for (int k = 0; k < AlphaNumericString.length(); k++) {

			if (Character.isLetter(AlphaNumericString.charAt(k)) && (n > 0)
					|| Character.isDigit(AlphaNumericString.charAt(k)) && (n > 0)) {

				r.append(AlphaNumericString.charAt(k));
				n--;
			}
		}

		// return the resultant string
		return r.toString();
	}

}
