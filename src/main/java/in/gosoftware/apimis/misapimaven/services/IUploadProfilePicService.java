package in.gosoftware.apimis.misapimaven.services;

import in.gosoftware.apimis.misapimaven.model.UploadProfilePic;

public interface IUploadProfilePicService {
	
	
	String create(UploadProfilePic uploadProfilePic);
	 void delete(String id);
	 void deletebyemail(String email);
	 UploadProfilePic findByEmail(String email);
}
