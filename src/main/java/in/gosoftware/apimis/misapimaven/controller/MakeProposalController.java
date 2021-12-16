package in.gosoftware.apimis.misapimaven.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

import in.gosoftware.apimis.misapimaven.model.Makeproposal;

import in.gosoftware.apimis.misapimaven.model.UploadProposalFile;
import in.gosoftware.apimis.misapimaven.repository.UploadPropRepo;
import in.gosoftware.apimis.misapimaven.services.MakeProposalService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
// @CrossOrigin(origins = "http://18.216.98.140")
@CrossOrigin(origins = "*")
@RequestMapping("api/proposal")
public class MakeProposalController {
	 public static String uploadDirectory = "/var/www/insuaps/html/prop";
	 //public static String uploadDirectory = System.getProperty("user.dir") +"/uploads";
	String filenames = "";

	// public static String uploadDirectory = "var/www/html/mis/uploads";
	@Autowired
	MakeProposalService makeProposalService;
	@Autowired
	UploadPropRepo uploadPropRepo;

	private static final Logger logger = Logger.getLogger(MakeProposalController.class.getName());

	@CrossOrigin(origins = "*")
	@PostMapping(value = "/uploadfile", headers = "Content-Type=multipart/form-data")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file,
			@RequestParam("cmpid") String cid, @RequestParam("propid") String propid,
			@RequestParam("filename") String filenametype) {

		try {
			if (file.isEmpty()) {

				filenames = "";// throw new UploadException("Failed to store empty file " + filename);
			} else {
				String randomnumber = getAlphaNumericString(20);
				filenames = randomnumber + "."
						+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

				Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
				UploadProposalFile uploadprop = new UploadProposalFile(cid, filenames, propid, filenametype);

				Files.write(fileNameAndPath, file.getBytes());
				makeProposalService.createprop(uploadprop);
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
	public UploadProposalFile updateuploadData(@RequestParam("file") MultipartFile file,
	@RequestParam("cmpid") String cid, @RequestParam("propid") String propid,
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
		UploadProposalFile uploadprop = new UploadProposalFile(id,cid, filenames, propid, filenametype);

		return makeProposalService.updateprop(uploadprop);
	}


	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getallfiles/{propid}", method = RequestMethod.GET)
	@ResponseBody

	public List<UploadProposalFile> getImage(@PathVariable("propid") String propid) {
		return uploadPropRepo.findByPropid(propid);
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
		 uploadPropRepo.deleteByPropidAndFilenametype(propid,filenametype);
		
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/proposalcreate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Mono<Makeproposal> create(@RequestBody Makeproposal makeProposal) {
		return makeProposalService.create(makeProposal);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allpropsalwithdate/{sdate}/{edate}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Flux<Makeproposal>> findAllWithDate(@PathVariable("sdate") String sadte,
			@PathVariable("edate") String edate) throws ParseException {
		Date sdates = new SimpleDateFormat("yyyy-MM-dd").parse(sadte);
		Date edates = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
		Flux<Makeproposal> makeprop = makeProposalService.findByCreatedon(sdates, edates);
		HttpStatus status = makeprop != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Flux<Makeproposal>>(makeprop, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/proposal/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Mono<Makeproposal>> findById(@PathVariable("id") String id) {
		Mono<Makeproposal> makeprop = makeProposalService.findById(id);
		HttpStatus status = makeprop != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Makeproposal>>(makeprop, status);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/allpropsal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Flux<Makeproposal> findAll() {
		Flux<Makeproposal> makeprop = makeProposalService.findAll();
		return makeprop;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/propupdate", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Mono<Makeproposal> update(@RequestBody Makeproposal makeprop) {
		return makeProposalService.update(makeprop);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/propdelete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") String id) {
		makeProposalService.delete(id).subscribe();
		makeProposalService.deleteFile(id);
	}

	 @GetMapping("/report/{id}")
	 
	     public String empReport(@PathVariable("id") String id) {
	 
	         return makeProposalService.generateReport(id);
	 
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
