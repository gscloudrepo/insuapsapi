package in.gosoftware.apimis.misapimaven.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "misfiles")
public class UploadMisFile {
	
	@Id
	private String id;
	private String cid;
	private  String filename;
	private String misid;
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
	
	
	public UploadMisFile() {
		super();
	}
	public UploadMisFile(String cid ,String filename,
			String misid,String filenametype) {
		
		this.cid = cid;
	
		
		this.filename = filename;
		
		this.filenametype = filenametype;
		this.misid = misid;
	}
	
	public UploadMisFile(String id,String cid ,String filename,String misid,String filenametype) {
		
		this.cid = cid;
	
		this.id = id;
		this.filename = filename;
		
		this.filenametype = filenametype;
		this.misid = misid;
	}
	

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return String return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return String return the misid
     */
    public String getmisid() {
        return misid;
    }

    /**
     * @param misid the misid to set
     */
    public void setmisid(String misid) {
        this.misid = misid;
    }


    /**
     * @return String return the filenametype
     */
    public String getFilenametype() {
        return filenametype;
    }

    /**
     * @param filenametype the filenametype to set
     */
    public void setFilenametype(String filenametype) {
        this.filenametype = filenametype;
    }
	

}
