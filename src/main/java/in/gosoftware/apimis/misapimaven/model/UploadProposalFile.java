package in.gosoftware.apimis.misapimaven.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "proposalfile")
public class UploadProposalFile {
	
	
	@Id
	private String id;
	private String cid;
	private  String filename;
	private String propid;
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
	
	
	public UploadProposalFile() {
		super();
	}
	public UploadProposalFile(String cid ,String filename,
			String propid,String filenametype) {
		
		this.cid = cid;
	
		
		this.filename = filename;
		
		this.filenametype = filenametype;
		this.propid = propid;
	}
	
	public UploadProposalFile(String id,String cid ,String filename,
			String propid,String filenametype) {
		
		this.cid = cid;
	
		this.id = id;
		this.filename = filename;
		
		this.filenametype = filenametype;
		this.propid = propid;
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
     * @return String return the propid
     */
    public String getPropid() {
        return propid;
    }

    /**
     * @param propid the propid to set
     */
    public void setPropid(String propid) {
        this.propid = propid;
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
