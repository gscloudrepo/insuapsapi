package in.gosoftware.apimis.misapimaven.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

import in.gosoftware.apimis.misapimaven.model.ClaimInfo;
import in.gosoftware.apimis.misapimaven.model.UploadClaimInfoFile;
import in.gosoftware.apimis.misapimaven.repository.UploadClaimInfoFileRepo;
import in.gosoftware.apimis.misapimaven.services.ClaimInfoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "*")
@RequestMapping("api/claiminfo")
public class ClaimInfoController {
	
	@Autowired
	private ClaimInfoService claimInfoService;
	@Autowired
	private UploadClaimInfoFileRepo uploadClaimInfoFileRepo;

	 public static String uploadDirectory = "/var/www/insuaps/html/claiminti";
	//public static String uploadDirectory = System.getProperty("user.dir") + "/uploads/claiminti/";
	String filenames = "";




	@CrossOrigin(origins = "*")
	@PostMapping(value = "/uploadfile", headers = "Content-Type=multipart/form-data")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file,
			@RequestParam("cmpid") String cid, @RequestParam("claiminfoid") String claiminfoid,
			@RequestParam("filename") String filenametype) {

		try {
			if (file.isEmpty()) {

				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
			} else {
				String randomnumber = getAlphaNumericString(25);
				filenames = randomnumber + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
				UploadClaimInfoFile uploadClaimInfoFile = new UploadClaimInfoFile(cid, filenames, claiminfoid, filenametype);

				Files.write(fileNameAndPath, file.getBytes());
				claimInfoService.createclaimmisfile(uploadClaimInfoFile);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// uploadVehicleFile.setFile(file);
		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>("Done", HttpStatus.OK);

	}
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/uploadmultiplefile", headers = "Content-Type=multipart/form-data")
	//@RequestMapping(value = "/uploadmultiplefile", method = RequestMethod.POST , headers = "Content-Type=multipart/form-data")
    public ResponseEntity<String> uploadingPost(@RequestParam("uploadingFiles") List<MultipartFile> uploadingFiles,@RequestParam("cmpid") String cid, @RequestParam("claiminfoid") String claiminfoid,
			@RequestParam("filename") String filenametype) throws IOException {
        for(MultipartFile file : uploadingFiles) {
        	System.out.println("filename:"+file.getOriginalFilename());
        	//this.uploadData(file,cid,claiminfoid,filenametype);
           // File file = new File(uploadDirectory + uploadedFile.getOriginalFilename());
          //  uploadedFile.transferTo(file);
        	try {
    			if (file.isEmpty()) {

    				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
    			} else {
    				String randomnumber = getAlphaNumericString(25);
    				filenames = randomnumber + "."
    						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

    				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
    				UploadClaimInfoFile uploadClaimInfoFile = new UploadClaimInfoFile(cid, filenames, claiminfoid, filenametype);

    				Files.write(fileNameAndPath, file.getBytes());
    				claimInfoService.createclaimmisfile(uploadClaimInfoFile);
    			}

    		} catch (IOException e) {
    			e.printStackTrace();
    		}
        }
      
    	return new ResponseEntity<String>("Done", HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/updateuploadfile", method = RequestMethod.PUT, headers = "Content-Type=multipart/form-data")
	@ResponseStatus(HttpStatus.OK)
	public UploadClaimInfoFile updateuploadData(@RequestParam("file") MultipartFile file,
	@RequestParam("cmpid") String cid, @RequestParam("claiminfoid") String claiminfoid,
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
		UploadClaimInfoFile uploadClaimInfoFile = new UploadClaimInfoFile(id,cid, filenames, claiminfoid, filenametype);

		return claimInfoService.updateclaiminfofile(uploadClaimInfoFile);
	}



	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/clinfocreate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void create(@RequestBody ClaimInfo claimInfo) {
		claimInfoService.create(claimInfo);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/clinfo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<ClaimInfo>> findById(@PathVariable("id") String id) {
		Mono<ClaimInfo> claimInfo = claimInfoService.findById(id);
		HttpStatus status = claimInfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<ClaimInfo>>(claimInfo, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allclinfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<ClaimInfo> findAll() { 	
		Flux<ClaimInfo> claimInfo = claimInfoService.findAll();
		return claimInfo;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/clinfoupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<ClaimInfo> update(@RequestBody ClaimInfo claimInfo) {
		return claimInfoService.update(claimInfo);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/clinfodelete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		claimInfoService.delete(id);
		claimInfoService.deleteFile(id);
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
	@RequestMapping(value = "/allclinfowithdate/{sdate}/{edate}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Flux<ClaimInfo>> findAllWithDate(@PathVariable("sdate") String sadte,
			@PathVariable("edate") String edate) throws ParseException {
		Date sdates = new SimpleDateFormat("yyyy-MM-dd").parse(sadte);
		Date edates = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		Flux<ClaimInfo> claimInfo = claimInfoService.findByCreatedon(sdates, edates);
		HttpStatus status = claimInfo != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Flux<ClaimInfo>>(claimInfo, status);
	}


	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getallfiles/{claiminfoid}", method = RequestMethod.GET)
	@ResponseBody

	public List<UploadClaimInfoFile> getImage(@PathVariable("claiminfoid") String claiminfoid) {
		return uploadClaimInfoFileRepo.findByClaiminfoid(claiminfoid);
		// UploadProposalFile img = new
		// UploadProposalFile(retrievedImage.get().getName(),
		// retrievedImage.get().getType(),
		// decompressBytes(retrievedImage.get().getPicByte()));
		// return img;
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/deletefile/{claiminfoid}/{filenametype}", method = RequestMethod.DELETE)
	@ResponseBody

	public void deleteFileByCliamInfoid(@PathVariable("claiminfoid") String claiminfoid,@PathVariable("filenametype") String filenametype) {
		uploadClaimInfoFileRepo.deleteByClaiminfoidAndFilenametype(claiminfoid,filenametype);
		
	}

	
	@GetMapping("/report/{id}")
	 
    public String empReport(@PathVariable("id") String id) {

        return claimInfoService.generateReport(id);

    }
	
	@GetMapping("/reportzip/{id}")
	 
    public String zipReport(@PathVariable("id") String id) throws IOException {

        return claimInfoService.getPhotoZip(id);

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
