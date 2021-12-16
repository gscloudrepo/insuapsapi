package in.gosoftware.apimis.misapimaven.model;


import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;

import reactor.core.publisher.Mono;
@Document(collection = "allvehicles")
public class VehicleInfo  {

	@Id
	private String id;
	
	private String cid;
	private String area;  
	private String vtype;  
	private String vmodel;  
	private String vmake; 
	private String vv;
	private String vno;  
	private String cc;
    private String yom; 
  //  private static final String MY_TIME_ZONE="Asia/Kolkata";
    @JsonFormat(pattern="yyyy-MM-dd"  )
   // @JsonFormat(pattern="yyyy-MM-dd"")
	private Date pdata;
    private String ptype; 
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private Date nid;
     
    private boolean nid_yn;
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private Date npd;
   
    private boolean npd_yn;
	private String icname;  
	private String ipno;  
    private String instype; 
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private Date nsd;
    
    private boolean nsd_yn; 
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private Date npucd;
    private boolean npucd_yn;
    @JsonFormat(pattern="yyyy-MM-dd"  ) 
    private Date nttd;
    
    private boolean nttd_yn;
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private Date slded;
    private boolean slded_yn;
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private Date nfd;
    private boolean nfd_yn;
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private Date ncid;
    private boolean ncid_yn;
	private String cmpid;
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private Date trexpd;
    private boolean trexpd_yn;
    private String contno;
    private String altcontno;
    private String emailid;
    private String state;
    private String city;
    private boolean customercontact;
    private String custtype;
    
   
    private String fueltype;
    @JsonFormat(pattern="yyyy-MM-dd"  )
    private String saledate;
    private String dname;
    public String pcode;
    
    
    public String status;
    
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
    
	public VehicleInfo(){

	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFueltype() {
		return fueltype;
	}

	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}

	public String getSaledate() {
		return saledate;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCusttype() {
		return custtype;
	}

	public void setCusttype(String custtype) {
		this.custtype = custtype;
	}

	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}



	public Date getTrexpd() {
		return trexpd;
	}



	public void setTrexpd(Date trexpd) {
		this.trexpd = trexpd;
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
     * @return String return the vtype
     */
    public String getVtype() {
        return vtype;
    }

    /**
     * @param vtype the vtype to set
     */
    public void setVtype(String vtype) {
        this.vtype = vtype;
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
     * @return String return the vv
     */
    public String getVv() {
        return vv;
    }

    /**
     * @param vv the vv to set
     */
    public void setVv(String vv) {
        this.vv = vv;
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
     * @return Date return the pdata
     */
    public Date getPdata() {
        return pdata;
    }

    /**
     * @param pdata the pdata to set
     */
    public void setPdata(Date pdata) {
        this.pdata = pdata;
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
     * @return Date return the nid
     */
    public Date getNid() {
        return nid;
    }

    /**
     * @param nid the nid to set
     */
    public void setNid(Date nid) {
        this.nid = nid;
    }

    /**
     * @return Date return the npd
     */
    public Date getNpd() {
        return npd;
    }

    /**
     * @param npd the npd to set
     */
    public void setNpd(Date npd) {
        this.npd = npd;
    }

    /**
     * @return String return the icname
     */
    public String getIcname() {
        return icname;
    }

    /**
     * @param icname the icname to set
     */
    public void setIcname(String icname) {
        this.icname = icname;
    }

    /**
     * @return String return the ipno
     */
    public String getIpno() {
        return ipno;
    }

    /**
     * @param ipno the ipno to set
     */
    public void setIpno(String ipno) {
        this.ipno = ipno;
    }

    /**
     * @return String return the instype
     */
    public String getInstype() {
        return instype;
    }

    /**
     * @param instype the instype to set
     */
    public void setInstype(String instype) {
        this.instype = instype;
    }

    /**
     * @return Date return the nsd
     */
    public Date getNsd() {
        return nsd;
    }

    /**
     * @param nsd the nsd to set
     */
    public void setNsd(Date nsd) {
        this.nsd = nsd;
    }

    /**
     * @return Date return the npucd
     */
    public Date getNpucd() {
        return npucd;
    }

    /**
     * @param npucd the npucd to set
     */
    public void setNpucd(Date npucd) {
        this.npucd = npucd;
    }

    /**
     * @return Date return the nttd
     */
    public Date getNttd() {
        return nttd;
    }

    /**
     * @param nttd the nttd to set
     */
    public void setNttd(Date nttd) {
        this.nttd = nttd;
    }

    /**
     * @return Date return the slded
     */
    public Date getSlded() {
        return slded;
    }

    /**
     * @param slded the slded to set
     */
    public void setSlded(Date slded) {
        this.slded = slded;
    }

    /**
     * @return Date return the nfd
     */
    public Date getNfd() {
        return nfd;
    }

    /**
     * @param nfd the nfd to set
     */
    public void setNfd(Date nfd) {
        this.nfd = nfd;
    }

    /**
     * @return Date return the ncid
     */
    public Date getNcid() {
        return ncid;
    }

    /**
     * @param ncid the ncid to set
     */
    public void setNcid(Date ncid) {
        this.ncid = ncid;
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
     * @return String return the contno
     */
    public String getContno() {
        return contno;
    }

    /**
     * @param contno the contno to set
     */
    public void setContno(String contno) {
        this.contno = contno;
    }

    /**
     * @return String return the altcontno
     */
    public String getAltcontno() {
        return altcontno;
    }

    /**
     * @param altcontno the altcontno to set
     */
    public void setAltcontno(String altcontno) {
        this.altcontno = altcontno;
    }

    /**
     * @return String return the emailid
     */
    public String getEmailid() {
        return emailid;
    }

    /**
     * @param emailid the emailid to set
     */
    public void setEmailid(String emailid) {
        this.emailid = emailid;
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
     * @return boolean return the nid_yn
     */
    public boolean isNid_yn() {
        return nid_yn;
    }

    /**
     * @param nid_yn the nid_yn to set
     */
    public void setNid_yn(boolean nid_yn) {
        this.nid_yn = nid_yn;
    }

    /**
     * @return boolean return the npd_yn
     */
    public boolean isNpd_yn() {
        return npd_yn;
    }

    /**
     * @param npd_yn the npd_yn to set
     */
    public void setNpd_yn(boolean npd_yn) {
        this.npd_yn = npd_yn;
    }

    /**
     * @return boolean return the nsd_yn
     */
    public boolean isNsd_yn() {
        return nsd_yn;
    }

    /**
     * @param nsd_yn the nsd_yn to set
     */
    public void setNsd_yn(boolean nsd_yn) {
        this.nsd_yn = nsd_yn;
    }

    /**
     * @return boolean return the npucd_yn
     */
    public boolean isNpucd_yn() {
        return npucd_yn;
    }

    /**
     * @param npucd_yn the npucd_yn to set
     */
    public void setNpucd_yn(boolean npucd_yn) {
        this.npucd_yn = npucd_yn;
    }

    /**
     * @return boolean return the nttd_yn
     */
    public boolean isNttd_yn() {
        return nttd_yn;
    }

    /**
     * @param nttd_yn the nttd_yn to set
     */
    public void setNttd_yn(boolean nttd_yn) {
        this.nttd_yn = nttd_yn;
    }

    /**
     * @return boolean return the slded_yn
     */
    public boolean isSlded_yn() {
        return slded_yn;
    }

    /**
     * @param slded_yn the slded_yn to set
     */
    public void setSlded_yn(boolean slded_yn) {
        this.slded_yn = slded_yn;
    }

    /**
     * @return boolean return the nfd_yn
     */
    public boolean isNfd_yn() {
        return nfd_yn;
    }

    /**
     * @param nfd_yn the nfd_yn to set
     */
    public void setNfd_yn(boolean nfd_yn) {
        this.nfd_yn = nfd_yn;
    }

    /**
     * @return boolean return the ncid_yn
     */
    public boolean isNcid_yn() {
        return ncid_yn;
    }

    /**
     * @param ncid_yn the ncid_yn to set
     */
    public void setNcid_yn(boolean ncid_yn) {
        this.ncid_yn = ncid_yn;
    }

    /**
     * @return boolean return the trexpd_yn
     */
    public boolean isTrexpd_yn() {
        return trexpd_yn;
    }

    /**
     * @param trexpd_yn the trexpd_yn to set
     */
    public void setTrexpd_yn(boolean trexpd_yn) {
        this.trexpd_yn = trexpd_yn;
    }


    /**
     * @return boolean return the customercontact
     */
    public boolean isCustomercontact() {
        return customercontact;
    }

    /**
     * @param customercontact the customercontact to set
     */
    public void setCustomercontact(boolean customercontact) {
        this.customercontact = customercontact;
    }

}
