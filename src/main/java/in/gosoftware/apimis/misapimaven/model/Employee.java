package in.gosoftware.apimis.misapimaven.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
@Document(collection = "emp_driver")
public class Employee {
	
	@Id
	
	private String id;
	private String customername;  
	private String name;  
	private String lastname;  
	private String area;
	private String designation;  
	private String al1;  
	private String al2;  
	private String city;
	private String pcode; 
	private String state;
	private String contact; 
	private String contactt; 

	private String email;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;  
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date doj;  
	private String licn;  
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date licnissdate; 
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date licnexp;  
	private String licno;  
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date licnexpdate;
	private String medicno;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date mediexpdate;
	private String vechno; 
	private String licdrive;
	private String cid;
    private String midname;
	private String fathername ;
	
	private String custcontactno;
	
	private String altcustcontactno;
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
	public Employee(){

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getAl1() {
		return al1;
	}
	public void setAl1(String al1) {
		this.al1 = al1;
	}
	public String getAl2() {
		return al2;
	}
	public void setAl2(String al2) {
		this.al2 = al2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContactt() {
		return contactt;
	}
	public void setContactt(String contactt) {
		this.contactt = contactt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getLicn() {
		return licn;
	}
	public void setLicn(String licn) {
		this.licn = licn;
	}
	public Date getLicnissdate() {
		return licnissdate;
	}
	public void setLicnissdate(Date licnissdate) {
		this.licnissdate = licnissdate;
	}
	public Date getLicnexp() {
		return licnexp;
	}
	public void setLicnexp(Date licnexp) {
		this.licnexp = licnexp;
	}
	public String getLicno() {
		return licno;
	}
	public void setLicno(String licno) {
		this.licno = licno;
	}
	public Date getLicnexpdate() {
		return licnexpdate;
	}
	public void setLicnexpdate(Date licnexpdate) {
		this.licnexpdate = licnexpdate;
	}
	public String getMedicno() {
		return medicno;
	}
	public void setMedicno(String medicno) {
		this.medicno = medicno;
	}
	public Date getMediexpdate() {
		return mediexpdate;
	}
	public void setMediexpdate(Date mediexpdate) {
		this.mediexpdate = mediexpdate;
	}
	public String getVechno() {
		return vechno;
	}
	public void setVechno(String vechno) {
		this.vechno = vechno;
	}
	public String getLicdrive() {
		return licdrive;
	}
	public void setLicdrive(String licdrive) {
		this.licdrive = licdrive;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getMidname() {
		return midname;
	}
	public void setMidname(String midname) {
		this.midname = midname;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public Employee(String id, String customername, String name, String lastname, String area, String designation,
			String al1, String al2, String city, String pcode, String state, String contact, String contactt,
			String email, Date dob, Date doj, String licn, Date licnissdate, Date licnexp, String licno,
			Date licnexpdate, String medicno, Date mediexpdate, String vechno, String licdrive, String cid,
			String midname, String fathername) {
		super();
		this.id = id;
		this.customername = customername;
		this.name = name;
		this.lastname = lastname;
		this.area = area;
		this.designation = designation;
		this.al1 = al1;
		this.al2 = al2;
		this.city = city;
		this.pcode = pcode;
		this.state = state;
		this.contact = contact;
		this.contactt = contactt;
		this.email = email;
		this.dob = dob;
		this.doj = doj;
		this.licn = licn;
		this.licnissdate = licnissdate;
		this.licnexp = licnexp;
		this.licno = licno;
		this.licnexpdate = licnexpdate;
		this.medicno = medicno;
		this.mediexpdate = mediexpdate;
		this.vechno = vechno;
		this.licdrive = licdrive;
		this.cid = cid;
		this.midname = midname;
		this.fathername = fathername;
	}
	
    

    /**
     * @return String return the custcontactno
     */
    public String getCustcontactno() {
        return custcontactno;
    }

    /**
     * @param custcontactno the custcontactno to set
     */
    public void setCustcontactno(String custcontactno) {
        this.custcontactno = custcontactno;
    }

    /**
     * @return String return the altcustcontactno
     */
    public String getAltcustcontactno() {
        return altcustcontactno;
    }

    /**
     * @param altcustcontactno the altcustcontactno to set
     */
    public void setAltcustcontactno(String altcustcontactno) {
        this.altcustcontactno = altcustcontactno;
    }

}
