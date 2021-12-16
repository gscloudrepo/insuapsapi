package in.gosoftware.apimis.misapimaven.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "profilepic")
public class UploadProfilePic {
	
	@Id
	private String id;
	private String cid;
	private  String filename;
	private String userid;
	private String email;
	private String usercode;
	private String username;
	

    public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public UploadProfilePic(String cid, String filename, String userid, String email) {
		super();
		this.cid = cid;
		this.filename = filename;
		this.userid = userid;
		this.email = email;
	}
	public UploadProfilePic() {
		super();
	}
	
	
}
