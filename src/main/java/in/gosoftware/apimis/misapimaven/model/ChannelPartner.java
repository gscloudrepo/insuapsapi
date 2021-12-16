package in.gosoftware.apimis.misapimaven.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
@Document(collection = "cp")
public class ChannelPartner {
	
	@Id
	
	private String id;
	private String ptype; 
	private String comp;  
	private String branch;  
	private String name;  
	private String lname;  
	private String desg;  
	private String adl1;  
	private String adl2;
	private String city; 
	private String pin;
	private String state; 
	private String mobile; 
	private String altmob;

	private String email;  
	private String dob;
	private String vfrom; 
	private String passw;  
	private String repassw;  
	private String cid;
    private boolean status;
    private String mpin;
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
	public ChannelPartner(){

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
     * @return String return the ptype
     */
    public String getPtype() {
        return ptype;
    }

    /**
     * @param ptype the ptype to set
     */
    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    /**
     * @return String return the comp
     */
    public String getComp() {
        return comp;
    }

    /**
     * @param comp the comp to set
     */
    public void setComp(String comp) {
        this.comp = comp;
    }

    /**
     * @return String return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return String return the desg
     */
    public String getDesg() {
        return desg;
    }

    /**
     * @param desg the desg to set
     */
    public void setDesg(String desg) {
        this.desg = desg;
    }

    /**
     * @return String return the adl1
     */
    public String getAdl1() {
        return adl1;
    }

    /**
     * @param adl1 the adl1 to set
     */
    public void setAdl1(String adl1) {
        this.adl1 = adl1;
    }

    /**
     * @return String return the adl2
     */
    public String getAdl2() {
        return adl2;
    }

    /**
     * @param adl2 the adl2 to set
     */
    public void setAdl2(String adl2) {
        this.adl2 = adl2;
    }

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return String return the pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * @return String return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return String return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return String return the altmob
     */
    public String getAltmob() {
        return altmob;
    }

    /**
     * @param altmob the altmob to set
     */
    public void setAltmob(String altmob) {
        this.altmob = altmob;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return String return the vfrom
     */
    public String getVfrom() {
        return vfrom;
    }

    /**
     * @param vfrom the vfrom to set
     */
    public void setVfrom(String vfrom) {
        this.vfrom = vfrom;
    }

    /**
     * @return String return the passw
     */
    public String getPassw() {
        return passw;
    }

    /**
     * @param passw the passw to set
     */
    public void setPassw(String passw) {
        this.passw = passw;
    }

    /**
     * @return String return the repassw
     */
    public String getRepassw() {
        return repassw;
    }

    /**
     * @param repassw the repassw to set
     */
    public void setRepassw(String repassw) {
        this.repassw = repassw;
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
     * @return boolean return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }


    /**
     * @return String return the mpin
     */
    public String getMpin() {
        return mpin;
    }

    /**
     * @param mpin the mpin to set
     */
    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

}
