package in.gosoftware.apimis.misapimaven.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.gosoftware.apimis.misapimaven.model.DateRange;
import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.model.UploadMisFile;
import in.gosoftware.apimis.misapimaven.model.UploadProposalFile;
import in.gosoftware.apimis.misapimaven.repository.MisRepo;
import in.gosoftware.apimis.misapimaven.repository.UploadMisRepo;
import in.gosoftware.apimis.misapimaven.services.MisService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "*")
@RequestMapping("api/mis")
public class MisController {

	@Autowired
	MisService misService;

	@Autowired
	UploadMisRepo uploadmisrepo;
	@Autowired
	MisRepo misRepo;

	 public static String uploadDirectory = "/var/www/insuaps/html/insurance";
	//public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	String filenames = "";




	@CrossOrigin(origins = "*")
	@PostMapping(value = "/uploadfile", headers = "Content-Type=multipart/form-data")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file,
			@RequestParam("cmpid") String cid, @RequestParam("misid") String misid,
			@RequestParam("filename") String filenametype) {

		try {
			if (file.isEmpty()) {

				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
			} else {
				String randomnumber = getAlphaNumericString(20);
				filenames = randomnumber + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
				UploadMisFile uploadMisFile = new UploadMisFile(cid, filenames, misid, filenametype);

				Files.write(fileNameAndPath, file.getBytes());
				misService.createmisfile(uploadMisFile);
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
	public UploadMisFile updateuploadData(@RequestParam("file") MultipartFile file,
	@RequestParam("cmpid") String cid, @RequestParam("misid") String misid,
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
		UploadMisFile uploadMisFile = new UploadMisFile(id,cid, filenames, misid, filenametype);

		return misService.updatemisfile(uploadMisFile);
	}



	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/miscreate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public String create(@RequestBody Mis mis) {
		return misService.create(mis);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/miscreate/all", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Flux<Mis> createAll(@RequestBody ArrayList<Mis> mis) {
		return misRepo.saveAll(mis);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/mis/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Mis>> findById(@PathVariable("id") String id) {
		Mono<Mis> mis = misService.findById(id);
		HttpStatus status = mis != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Mis>>(mis, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allmis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<Mis> findAll() {
		Flux<Mis> mis = misService.findAll();
		return mis;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/misupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<Mis> update(@RequestBody Mis mis) {
		return misService.update(mis);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/misdelete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		misService.delete(id);
		misService.deleteFile(id);
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
	@RequestMapping(value = "/allmiswithdate/{sdate}/{edate}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Flux<Mis>> findAllWithDate(@PathVariable("sdate") String sadte,
			@PathVariable("edate") String edate) throws ParseException {
		Date sdates = new SimpleDateFormat("yyyy-MM-dd").parse(sadte);
		Date edates = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		Flux<Mis> mis = misService.findByCreatedon(sdates, edates);
		HttpStatus status = mis != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Flux<Mis>>(mis, status);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allpolicyexpmiswithdate/{sdate}/{edate}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Flux<Mis>> findPolicyExpWithDate(@PathVariable("sdate") String sadte,
			@PathVariable("edate") String edate) throws ParseException {
		Date sdates = new SimpleDateFormat("yyyy-MM-dd").parse(sadte);
		Date edates = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		Flux<Mis> mis = misService.findByPolicyexpiry(sdates, edates);
		HttpStatus status = mis != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Flux<Mis>>(mis, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getallfiles/{misid}", method = RequestMethod.GET)
	@ResponseBody

	public List<UploadMisFile> getImage(@PathVariable("misid") String misid) {
		return uploadmisrepo.findByMisid(misid);
		// UploadProposalFile img = new
		// UploadProposalFile(retrievedImage.get().getName(),
		// retrievedImage.get().getType(),
		// decompressBytes(retrievedImage.get().getPicByte()));
		// return img;
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/deletefile/{misid}/{filenametype}", method = RequestMethod.DELETE)
	@ResponseBody

	public void deleteFileByMisid(@PathVariable("misid") String misid,@PathVariable("filenametype") String filenametype) {
		uploadmisrepo.deleteByMisidAndFilenametype(misid,filenametype);
		
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
