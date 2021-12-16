package in.gosoftware.apimis.misapimaven.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "appointmnets")
public class Appointment {
	
	@Id
	private String id;
	private String cmpid;
	private String appostatus;
	@JsonFormat(pattern="yyyy-MM-dd")
   	private Date appodt;
	private String comment;
	private String status;
	private String cc;
	private String yom;
	private String vmake;
	private String vmodel;
	private String email;
	private String vno;
	private String cname;
	private String contact;
	private String alternetcontant;
	private String area;
	private String state;
	private String datetype;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date datefor;
	private String callername;
	private Date calldt;
	private String custtype;
	private String calltime;
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

	public String getCalltime() {
		return calltime;
	}

	public void setCalltime(String calltime) {
		this.calltime = calltime;
	}

	public String getCusttype() {
		return custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	public String getCallername() {
		return callername;
	}

	public void setCallername(String callername) {
		this.callername = callername;
	}

	public Date getCalldt() {
		return calldt;
	}

	public void setCalldt(Date calldt) {
		this.calldt = calldt;
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
     * @return String return the cmpid
     */
    public String getCmpid() {
        return cmpid;
    }

    /**
     * @param cmpid the cmpid to set
     */
    public void setCmpid(String cmpid) {
        this.cmpid = cmpid;
    }

    /**
     * @return String return the appostatus
     */
    public String getAppostatus() {
        return appostatus;
    }

    /**
     * @param appostatus the appostatus to set
     */
    public void setAppostatus(String appostatus) {
        this.appostatus = appostatus;
    }

    /**
     * @return Date return the appodt
     */
    public Date getAppodt() {
        return appodt;
    }

    /**
     * @param appodt the appodt to set
     */
    public void setAppodt(Date appodt) {
        this.appodt = appodt;
    }

    /**
     * @return String return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return String return the cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * @return String return the yom
     */
    public String getYom() {
        return yom;
    }

    /**
     * @param yom the yom to set
     */
    public void setYom(String yom) {
        this.yom = yom;
    }

    /**
     * @return String return the vmake
     */
    public String getVmake() {
        return vmake;
    }

    /**
     * @param vmake the vmake to set
     */
    public void setVmake(String vmake) {
        this.vmake = vmake;
    }

    /**
     * @return String return the vmodel
     */
    public String getVmodel() {
        return vmodel;
    }

    /**
     * @param vmodel the vmodel to set
     */
    public void setVmodel(String vmodel) {
        this.vmodel = vmodel;
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
     * @return String return the vno
     */
    public String getVno() {
        return vno;
    }

    /**
     * @param vno the vno to set
     */
    public void setVno(String vno) {
        this.vno = vno;
    }

    /**
     * @return String return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }

    /**
     * @return String return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return String return the alternetcontant
     */
    public String getAlternetcontant() {
        return alternetcontant;
    }

    /**
     * @param alternetcontant the alternetcontant to set
     */
    public void setAlternetcontant(String alternetcontant) {
        this.alternetcontant = alternetcontant;
    }

    /**
     * @return String return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
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
     * @return String return the datetype
     */
    public String getDatetype() {
        return datetype;
    }

    /**
     * @param datetype the datetype to set
     */
    public void setDatetype(String datetype) {
        this.datetype = datetype;
    }

    /**
     * @return Date return the datefor
     */
    public Date getDatefor() {
        return datefor;
    }

    /**
     * @param datefor the datefor to set
     */
    public void setDatefor(Date datefor) {
        this.datefor = datefor;
    }

}
