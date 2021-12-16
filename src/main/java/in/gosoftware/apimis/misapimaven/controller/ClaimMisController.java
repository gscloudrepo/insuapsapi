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

import in.gosoftware.apimis.misapimaven.model.ClaimMis;
import in.gosoftware.apimis.misapimaven.model.Mis;
import in.gosoftware.apimis.misapimaven.model.UploadClaimMisFile;
import in.gosoftware.apimis.misapimaven.model.UploadMisFile;
import in.gosoftware.apimis.misapimaven.repository.UploadClaimMisRepo;
import in.gosoftware.apimis.misapimaven.repository.UploadMisRepo;
import in.gosoftware.apimis.misapimaven.services.ClaimMisService;
import in.gosoftware.apimis.misapimaven.services.MisService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "*")
@RequestMapping("api/claimmis")
public class ClaimMisController {

	
	@Autowired
	ClaimMisService claimmisService;
	@Autowired
	UploadClaimMisRepo uploadcliammisrepo;

	 public static String uploadDirectory = "/var/www/insuaps/html/claimmis";
	//public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
	String filenames = "";




	@CrossOrigin(origins = "*")
	@PostMapping(value = "/uploadfile", headers = "Content-Type=multipart/form-data")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file,
			@RequestParam("cmpid") String cid, @RequestParam("claimmisid") String claimmisid,
			@RequestParam("filename") String filenametype) {

		try {
			if (file.isEmpty()) {

				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
			} else {
				String randomnumber = getAlphaNumericString(25);
				filenames = randomnumber + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
				UploadClaimMisFile uploadclaimMisFile = new UploadClaimMisFile(cid, filenames, claimmisid, filenametype);

				Files.write(fileNameAndPath, file.getBytes());
				claimmisService.createclaimmisfile(uploadclaimMisFile);
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
	public UploadClaimMisFile updateuploadData(@RequestParam("file") MultipartFile file,
	@RequestParam("cmpid") String cid, @RequestParam("claimmisid") String claimmisid,
	@RequestParam("filename") String filenametype,@RequestParam("id") String id)
	 {

		try {
			if (file.isEmpty()) {

				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
			} else {
				String randomnumber = getAlphaNumericString(25);
				filenames = randomnumber + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);

				Files.write(fileNameAndPath, file.getBytes());
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		UploadClaimMisFile uploadClaimMisFile = new UploadClaimMisFile(id,cid, filenames, claimmisid, filenametype);

		return claimmisService.updateclaimmisfile(uploadClaimMisFile);
	}



	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cmiscreate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody ClaimMis claimMis) {
		claimmisService.create(claimMis);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cmis/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<ClaimMis>> findById(@PathVariable("id") String id) {
		Mono<ClaimMis> claimMis = claimmisService.findById(id);
		HttpStatus status = claimMis != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<ClaimMis>>(claimMis, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allcmis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<ClaimMis> findAll() { 	
		Flux<ClaimMis> claimMis = claimmisService.findAll();
		return claimMis;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cmisupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<ClaimMis> update(@RequestBody ClaimMis claimMis) {
		return claimmisService.update(claimMis);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/cmisdelete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		claimmisService.delete(id);
	claimmisService.deleteFile(id);
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
	@RequestMapping(value = "/allcmiswithdate/{sdate}/{edate}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Flux<ClaimMis>> findAllWithDate(@PathVariable("sdate") String sadte,
			@PathVariable("edate") String edate) throws ParseException {
		Date sdates = new SimpleDateFormat("yyyy-MM-dd").parse(sadte);
		Date edates = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		Flux<ClaimMis> claimMis = claimmisService.findByCreatedon(sdates, edates);
		HttpStatus status = claimMis != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Flux<ClaimMis>>(claimMis, status);
	}


	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getallfiles/{claimmisid}", method = RequestMethod.GET)
	@ResponseBody

	public List<UploadClaimMisFile> getImage(@PathVariable("claimmisid") String claimmisid) {
		return uploadcliammisrepo.findByClaimmisid(claimmisid);
		// UploadProposalFile img = new
		// UploadProposalFile(retrievedImage.get().getName(),
		// retrievedImage.get().getType(),
		// decompressBytes(retrievedImage.get().getPicByte()));
		// return img;
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/deletefile/{claimmisid}/{filenametype}", method = RequestMethod.DELETE)
	@ResponseBody

	public void deleteFileByMisid(@PathVariable("claimmisid") String claimmisid,@PathVariable("filenametype") String filenametype) {
		uploadcliammisrepo.deleteByClaimmisidAndFilenametype(claimmisid,filenametype);
		
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



