package in.gosoftware.apimis.misapimaven.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.gosoftware.apimis.misapimaven.model.UploadProfilePic;
import in.gosoftware.apimis.misapimaven.model.UploadProposalFile;
import in.gosoftware.apimis.misapimaven.model.User;
import in.gosoftware.apimis.misapimaven.repository.ProfilepicRepo;
import in.gosoftware.apimis.misapimaven.services.CompanyService;
import in.gosoftware.apimis.misapimaven.services.UploadProfilePicService;

@RestController
//@CrossOrigin(origins = "http://18.216.98.140")
@CrossOrigin(origins = "*")
@RequestMapping("api/profilepic")
public class UploadProfilePicController {
	
	@Autowired
	ProfilepicRepo profilepicrepo;
	@Autowired
	private CompanyService companyService;
	 public static String uploadDirectory = "/var/www/insuaps/html/";
	 //public static String uploadDirectory = System.getProperty("user.dir") +"/uploads";
	String filenames = "";
	private static final Logger logger = Logger.getLogger(UploadProfilePicController.class.getName());
	@Autowired
	UploadProfilePicService uploadProfilePicService;
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/uploadfile", headers = "Content-Type=multipart/form-data")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file,
			@RequestParam("cid") String cid, @RequestParam("email") String email) {
		
		if(profilepicrepo.existsByEmail(email)) {
			uploadProfilePicService.deletebyemail(email);
			String userid=companyService.findByEmail(email).getId();

			try {
				if (file.isEmpty()) {

					filenames = "";// throw new UploadException("Failed to store empty file " + filename);
				} else {
					String randomnumber = getAlphaNumericString(25);
					filenames = randomnumber + "."+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

					Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
					UploadProfilePic uploadProfilePic = new UploadProfilePic(cid, filenames, userid,email);

					Files.write(fileNameAndPath, file.getBytes());
					uploadProfilePicService.create(uploadProfilePic);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			// uploadVehicleFile.setFile(file);
			// Do processing with uploaded file data in Service layer
			return new ResponseEntity<String>("Delete and Upload", HttpStatus.OK);
		}
		
		else {
			String userid=companyService.findByEmail(email).getId();

			try {
				if (file.isEmpty()) {

					filenames = "";// throw new UploadException("Failed to store empty file " + filename);
				} else {
					String randomnumber = getAlphaNumericString(25);
					filenames = randomnumber + "."+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

					Path fileNameAndPath = Paths.get(uploadDirectory, filenames);
					UploadProfilePic uploadProfilePic = new UploadProfilePic(cid, filenames, userid,email);

					Files.write(fileNameAndPath, file.getBytes());
					uploadProfilePicService.create(uploadProfilePic);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			// uploadVehicleFile.setFile(file);
			// Do processing with uploaded file data in Service layer
			return new ResponseEntity<String>("Done", HttpStatus.OK);
		}

	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/deleteprofile/{email}", method = RequestMethod.DELETE)
	@ResponseBody

	public void deleteFileByPropid(@PathVariable("email") String email) {
		uploadProfilePicService.deletebyemail(email);
	
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getprofile/{emailid}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UploadProfilePic> findByEmail(@PathVariable("emailid") String emailid) {
		UploadProfilePic user = uploadProfilePicService.findByEmail(emailid);
		HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<UploadProfilePic>(user, status);
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
