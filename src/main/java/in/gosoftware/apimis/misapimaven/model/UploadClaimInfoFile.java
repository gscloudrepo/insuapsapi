package in.gosoftware.apimis.misapimaven.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "claiminfofiles")
public class UploadClaimInfoFile {

	@Id
	private String id;
	private String cid;
	private  String filename;
	private String claiminfoid;
	private String filenametype;
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
	public String getClaiminfoid() {
		return claiminfoid;
	}
	public void setClaiminfoid(String claiminfoid) {
		this.claiminfoid = claiminfoid;
	}
	public String getFilenametype() {
		return filenametype;
	}
	public void setFilenametype(String filenametype) {
		this.filenametype = filenametype;
	}
	public UploadClaimInfoFile(String cid, String filename, String claiminfoid, String filenametype) {
		super();
		this.cid = cid;
		this.filename = filename;
		this.claiminfoid = claiminfoid;
		this.filenametype = filenametype;
	}
	public UploadClaimInfoFile(String id, String cid, String filename, String claiminfoid, String filenametype) {
		super();
		this.id = id;
		this.cid = cid;
		this.filename = filename;
		this.claiminfoid = claiminfoid;
		this.filenametype = filenametype;
	}
	public UploadClaimInfoFile() {
		super();
	}
	
	
}
