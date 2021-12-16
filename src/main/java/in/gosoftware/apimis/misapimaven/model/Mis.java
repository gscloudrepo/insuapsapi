package in.gosoftware.apimis.misapimaven.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
@Document(collection = "mis")
public class Mis {
@Id
private String id;
private String cmpid;
private String customername;
private String vname;
private String area;
private String vtype;
private String vmake;
private String vmodel;
private String yom;
private String vno;
private String cc;
private String mobileno;
private String whatsappno;
private String alternateno;
private String emailid;
private String policytype;
private String idv;
private String od;
private String discount;
private String ncb;
private String addon;
private String tp;
private String premium;
private String gst;
private String finalpremium;
private String policyno;
@JsonFormat(pattern="yyyy-MM-dd")
private Date issue;
@JsonFormat(pattern="yyyy-MM-dd")
private Date expiry;
private String company;
private String agentcode;
private String managername;
private String business;
private String callby;
private String pickupby;
private String cpartner;
private String policystatus;
private String policydeliv;
private String customerreview;
private String cashback;
private String commission;
private String payoutamount;
private String payoutrelease;
private String payoutmode;
@JsonFormat(pattern="yyyy-MM-dd")
private Date payoutdate;
private String state;
private String pcode;
@JsonFormat(pattern="yyyy-MM-dd")
private Date vregdate;
private String scap;
private String discountper;
private String fueltype;
private String basiclibtp;
private String totalncb;
private String ll_paid;
private String ll_paid_other;
private String totaladdon;
private String pc;
private String chequeno;
private String bank_name;
@JsonFormat(pattern="yyyy-MM-dd")
private Date chq_date;
private String totodpre;
private String pa;
private String geoext;
private String imt;
private String paymentmode;
private String comments;
private String extpaymentmode;
private String chequeno1;
private String bank_name1;
@JsonFormat(pattern="yyyy-MM-dd")
private Date chq_date1;
@JsonFormat(pattern="yyyy-MM-dd")
private Date createdon;
private String amnt1;
private String amnt2;
private String comment;
private String eng_no;
private String che_no;
private String fin_name;
private boolean customercontact;
private String custtype;
private String savefor;
@JsonFormat(pattern="yyyy-MM-dd")
private Date dob;

@JsonFormat(pattern="yyyy-MM-dd")
private Date ninspd;
private String fathername;
private String amnt3;
private String businesstype;
private String licdrive;
private String taxtype;
private String cmpname;
private String imeino;
private String simno;
private String gpstype;
private String sldtype;
private String purtype;
private String cerno;
private String name;
@JsonFormat(pattern="yyyy-MM-dd")
private Date dob_n;
private String rel_n;
private String hequeneftno;
private String  agentname;
private boolean zerodep;
private boolean rsa_chk;
private boolean consumable;
private boolean ecover;
private boolean ncbprotect;
private boolean typecover;
private boolean lossofkeys;
private boolean cc_add;
private boolean sc;
private boolean roi;
private boolean mc;
private boolean dc;
private boolean rtc;
private boolean at;
private boolean vas;
private boolean imt23;
private String commision;
private String codper;
private String ctpper;
private String cnetper;
private String payoutval;
private String podper;
private String ptpper;
private String pnetper;
private String camount;
private String cpaid;
private String coutmode;
@JsonFormat(pattern="yyyy-MM-dd")
private Date cmdate;
private String comrec;
private String cmmode;
private String comchequeneftno;
@JsonFormat(pattern="yyyy-MM-dd")
private Date crecdate;
private String status;

private String remark;
private String remarks;
private String remarkss;

private String chequeneftno; 
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
public Mis() {
	
}



 public String getChequeneftno() {
	return chequeneftno;
}



public void setChequeneftno(String chequeneftno) {
	this.chequeneftno = chequeneftno;
}



public String getRemark() {
	return remark;
}



public void setRemark(String remark) {
	this.remark = remark;
}



public String getRemarks() {
	return remarks;
}



public void setRemarks(String remarks) {
	this.remarks = remarks;
}



public String getRemarkss() {
	return remarkss;
}



public void setRemarkss(String remarkss) {
	this.remarkss = remarkss;
}



public String getStatus() {
	return status;
}



public void setStatus(String status) {
	this.status = status;
}



public String getCommision() {
	return commision;
}



public void setCommision(String commision) {
	this.commision = commision;
}



public String getCodper() {
	return codper;
}



public void setCodper(String codper) {
	this.codper = codper;
}



public String getCtpper() {
	return ctpper;
}



public void setCtpper(String ctpper) {
	this.ctpper = ctpper;
}



public String getCnetper() {
	return cnetper;
}



public void setCnetper(String cnetper) {
	this.cnetper = cnetper;
}



public String getPayoutval() {
	return payoutval;
}



public void setPayoutval(String payoutval) {
	this.payoutval = payoutval;
}



public String getPodper() {
	return podper;
}



public void setPodper(String podper) {
	this.podper = podper;
}



public String getPtpper() {
	return ptpper;
}



public void setPtpper(String ptpper) {
	this.ptpper = ptpper;
}



public String getPnetper() {
	return pnetper;
}



public void setPnetper(String pnetper) {
	this.pnetper = pnetper;
}



public String getCamount() {
	return camount;
}



public void setCamount(String camount) {
	this.camount = camount;
}



public String getCpaid() {
	return cpaid;
}



public void setCpaid(String cpaid) {
	this.cpaid = cpaid;
}



public String getCoutmode() {
	return coutmode;
}



public void setCoutmode(String coutmode) {
	this.coutmode = coutmode;
}



public Date getCmdate() {
	return cmdate;
}



public void setCmdate(Date cmdate) {
	this.cmdate = cmdate;
}



public String getComrec() {
	return comrec;
}



public void setComrec(String comrec) {
	this.comrec = comrec;
}



public String getCmmode() {
	return cmmode;
}



public void setCmmode(String cmmode) {
	this.cmmode = cmmode;
}



public String getComchequeneftno() {
	return comchequeneftno;
}



public void setComchequeneftno(String comchequeneftno) {
	this.comchequeneftno = comchequeneftno;
}



public Date getCrecdate() {
	return crecdate;
}



public void setCrecdate(Date crecdate) {
	this.crecdate = crecdate;
}



public String getHequeneftno() {
	return hequeneftno;
}



public void setHequeneftno(String hequeneftno) {
	this.hequeneftno = hequeneftno;
}






public String getAgentname() {
	return agentname;
}



public void setAgentname(String agentname) {
	this.agentname = agentname;
}



public boolean isZerodep() {
	return zerodep;
}



public void setZerodep(boolean zerodep) {
	this.zerodep = zerodep;
}



public boolean isRsa_chk() {
	return rsa_chk;
}



public void setRsa_chk(boolean rsa_chk) {
	this.rsa_chk = rsa_chk;
}



public boolean isConsumable() {
	return consumable;
}



public void setConsumable(boolean consumable) {
	this.consumable = consumable;
}



public boolean isEcover() {
	return ecover;
}



public void setEcover(boolean ecover) {
	this.ecover = ecover;
}



public boolean isNcbprotect() {
	return ncbprotect;
}



public void setNcbprotect(boolean ncbprotect) {
	this.ncbprotect = ncbprotect;
}



public boolean isTypecover() {
	return typecover;
}



public void setTypecover(boolean typecover) {
	this.typecover = typecover;
}



public boolean isLossofkeys() {
	return lossofkeys;
}



public void setLossofkeys(boolean lossofkeys) {
	this.lossofkeys = lossofkeys;
}



public boolean isCc_add() {
	return cc_add;
}



public void setCc_add(boolean cc_add) {
	this.cc_add = cc_add;
}



public boolean isSc() {
	return sc;
}



public void setSc(boolean sc) {
	this.sc = sc;
}



public boolean isRoi() {
	return roi;
}



public void setRoi(boolean roi) {
	this.roi = roi;
}



public boolean isMc() {
	return mc;
}



public void setMc(boolean mc) {
	this.mc = mc;
}



public boolean isDc() {
	return dc;
}



public void setDc(boolean dc) {
	this.dc = dc;
}



public boolean isRtc() {
	return rtc;
}



public void setRtc(boolean rtc) {
	this.rtc = rtc;
}



public boolean isAt() {
	return at;
}



public void setAt(boolean at) {
	this.at = at;
}



public boolean isVas() {
	return vas;
}



public void setVas(boolean vas) {
	this.vas = vas;
}



public boolean isImt23() {
	return imt23;
}



public void setImt23(boolean imt23) {
	this.imt23 = imt23;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public Date getDob_n() {
	return dob_n;
}



public void setDob_n(Date dob_n) {
	this.dob_n = dob_n;
}



public String getRel_n() {
	return rel_n;
}



public void setRel_n(String rel_n) {
	this.rel_n = rel_n;
}



public String getSldtype() {
	return sldtype;
}



public void setSldtype(String sldtype) {
	this.sldtype = sldtype;
}



public String getPurtype() {
	return purtype;
}



public void setPurtype(String purtype) {
	this.purtype = purtype;
}



public String getCerno() {
	return cerno;
}



public void setCerno(String cerno) {
	this.cerno = cerno;
}



public String getCmpname() {
	return cmpname;
}



public void setCmpname(String cmpname) {
	this.cmpname = cmpname;
}



public String getImeino() {
	return imeino;
}



public void setImeino(String imeino) {
	this.imeino = imeino;
}



public String getSimno() {
	return simno;
}



public void setSimno(String simno) {
	this.simno = simno;
}



public String getGpstype() {
	return gpstype;
}



public void setGpstype(String gpstype) {
	this.gpstype = gpstype;
}



public String getTaxtype() {
	return taxtype;
}



public void setTaxtype(String taxtype) {
	this.taxtype = taxtype;
}



public String getFathername() {
	return fathername;
}



public void setFathername(String fathername) {
	this.fathername = fathername;
}



public String getAmnt3() {
	return amnt3;
}



public void setAmnt3(String amnt3) {
	this.amnt3 = amnt3;
}



public String getBusinesstype() {
	return businesstype;
}



public void setBusinesstype(String businesstype) {
	this.businesstype = businesstype;
}



public String getLicdrive() {
	return licdrive;
}



public void setLicdrive(String licdrive) {
	this.licdrive = licdrive;
}



public Date getNinspd() {
	return ninspd;
}



public void setNinspd(Date ninspd) {
	this.ninspd = ninspd;
}



public Date getIssue() {
	return issue;
}



public void setIssue(Date issue) {
	this.issue = issue;
}



public Date getExpiry() {
	return expiry;
}



public void setExpiry(Date expiry) {
	this.expiry = expiry;
}



public String getSavefor() {
	return savefor;
}

public void setSavefor(String savefor) {
	this.savefor = savefor;
}



public Date getDob() {
	return dob;
}



public void setDob(Date dob) {
	this.dob = dob;
}



public String getCusttype() {
	return custtype;
}

public void setCusttype(String custtype) {
	this.custtype = custtype;
}

public boolean isCustomercontact() {
	return customercontact;
}

public void setCustomercontact(boolean customercontact) {
	this.customercontact = customercontact;
}

/**
     * @return String return the id
     */
    public String getFinalpremium() {
        return finalpremium;
    }

    /**
     * @param id the id to set
     */
    public void setFinalpremium(String finalpremium) {
        this.finalpremium = finalpremium;
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
     * @return String return the customername
     */
    public String getCustomername() {
        return customername;
    }

    /**
     * @param customername the customername to set
     */
    public void setCustomername(String customername) {
        this.customername = customername;
    }

    /**
     * @return String return the vname
     */
    public String getVname() {
        return vname;
    }

    /**
     * @param vname the vname to set
     */
    public void setVname(String vname) {
        this.vname = vname;
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
     * @return String return the mobileno
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * @param mobileno the mobileno to set
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    /**
     * @return String return the whatsappno
     */
    public String getWhatsappno() {
        return whatsappno;
    }

    /**
     * @param whatsappno the whatsappno to set
     */
    public void setWhatsappno(String whatsappno) {
        this.whatsappno = whatsappno;
    }

    /**
     * @return String return the alternateno
     */
    public String getAlternateno() {
        return alternateno;
    }

    /**
     * @param alternateno the alternateno to set
     */
    public void setAlternateno(String alternateno) {
        this.alternateno = alternateno;
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
     * @return String return the policytype
     */
    public String getPolicytype() {
        return policytype;
    }

    /**
     * @param policytype the policytype to set
     */
    public void setPolicytype(String policytype) {
        this.policytype = policytype;
    }

    /**
     * @return String return the idv
     */
    public String getIdv() {
        return idv;
    }

    /**
     * @param idv the idv to set
     */
    public void setIdv(String idv) {
        this.idv = idv;
    }

    /**
     * @return String return the od
     */
    public String getOd() {
        return od;
    }

    /**
     * @param od the od to set
     */
    public void setOd(String od) {
        this.od = od;
    }

    /**
     * @return String return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * @return String return the ncb
     */
    public String getNcb() {
        return ncb;
    }

    /**
     * @param ncb the ncb to set
     */
    public void setNcb(String ncb) {
        this.ncb = ncb;
    }

    /**
     * @return String return the addon
     */
    public String getAddon() {
        return addon;
    }

    /**
     * @param addon the addon to set
     */
    public void setAddon(String addon) {
        this.addon = addon;
    }

    /**
     * @return String return the tp
     */
    public String getTp() {
        return tp;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(String tp) {
        this.tp = tp;
    }

    /**
     * @return String return the premium
     */
    public String getPremium() {
        return premium;
    }

    /**
     * @param premium the premium to set
     */
    public void setPremium(String premium) {
        this.premium = premium;
    }

    /**
     * @return String return the gst
     */
    public String getGst() {
        return gst;
    }

    /**
     * @param gst the gst to set
     */
    public void setGst(String gst) {
        this.gst = gst;
    }

    /**
     * @return String return the policyno
     */
    public String getPolicyno() {
        return policyno;
    }

    /**
     * @param policyno the policyno to set
     */
    public void setPolicyno(String policyno) {
        this.policyno = policyno;
    }

    /**
     * @return Date return the policystart
     */
   
    /**
     * @return String return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return String return the agentcode
     */
    public String getAgentcode() {
        return agentcode;
    }

    /**
     * @param agentcode the agentcode to set
     */
    public void setAgentcode(String agentcode) {
        this.agentcode = agentcode;
    }

    /**
     * @return String return the managername
     */
    public String getManagername() {
        return managername;
    }

    /**
     * @param managername the managername to set
     */
    public void setManagername(String managername) {
        this.managername = managername;
    }

    /**
     * @return String return the business
     */
    public String getBusiness() {
        return business;
    }

    /**
     * @param business the business to set
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * @return String return the callby
     */
    public String getCallby() {
        return callby;
    }

    /**
     * @param callby the callby to set
     */
    public void setCallby(String callby) {
        this.callby = callby;
    }

    /**
     * @return String return the pickupby
     */
    public String getPickupby() {
        return pickupby;
    }

    /**
     * @param pickupby the pickupby to set
     */
    public void setPickupby(String pickupby) {
        this.pickupby = pickupby;
    }

    /**
     * @return String return the cpartner
     */
    public String getCpartner() {
        return cpartner;
    }

    /**
     * @param cpartner the cpartner to set
     */
    public void setCpartner(String cpartner) {
        this.cpartner = cpartner;
    }

    /**
     * @return String return the policystatus
     */
    public String getPolicystatus() {
        return policystatus;
    }

    /**
     * @param policystatus the policystatus to set
     */
    public void setPolicystatus(String policystatus) {
        this.policystatus = policystatus;
    }

    /**
     * @return String return the policydeliv
     */
    public String getPolicydeliv() {
        return policydeliv;
    }

    /**
     * @param policydeliv the policydeliv to set
     */
    public void setPolicydeliv(String policydeliv) {
        this.policydeliv = policydeliv;
    }

    /**
     * @return String return the customerreview
     */
    public String getCustomerreview() {
        return customerreview;
    }

    /**
     * @param customerreview the customerreview to set
     */
    public void setCustomerreview(String customerreview) {
        this.customerreview = customerreview;
    }

    /**
     * @return String return the cashback
     */
    public String getCashback() {
        return cashback;
    }

    /**
     * @param cashback the cashback to set
     */
    public void setCashback(String cashback) {
        this.cashback = cashback;
    }

    /**
     * @return String return the commission
     */
    public String getCommission() {
        return commission;
    }

    /**
     * @param commission the commission to set
     */
    public void setCommission(String commission) {
        this.commission = commission;
    }

    /**
     * @return String return the payoutamount
     */
    public String getPayoutamount() {
        return payoutamount;
    }

    /**
     * @param payoutamount the payoutamount to set
     */
    public void setPayoutamount(String payoutamount) {
        this.payoutamount = payoutamount;
    }

    /**
     * @return String return the payoutrelease
     */
    public String getPayoutrelease() {
        return payoutrelease;
    }

    /**
     * @param payoutrelease the payoutrelease to set
     */
    public void setPayoutrelease(String payoutrelease) {
        this.payoutrelease = payoutrelease;
    }

    /**
     * @return String return the payoutmode
     */
    public String getPayoutmode() {
        return payoutmode;
    }

    /**
     * @param payoutmode the payoutmode to set
     */
    public void setPayoutmode(String payoutmode) {
        this.payoutmode = payoutmode;
    }

    /**
     * @return Date return the payoutdate
     */
    public Date getPayoutdate() {
        return payoutdate;
    }

    /**
     * @param payoutdate the payoutdate to set
     */
    public void setPayoutdate(Date payoutdate) {
        this.payoutdate = payoutdate;
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
     * @return String return the pcode
     */
    public String getPcode() {
        return pcode;
    }

    /**
     * @param pcode the pcode to set
     */
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    /**
     * @return Date return the vregdate
     */
    public Date getVregdate() {
        return vregdate;
    }

    /**
     * @param vregdate the vregdate to set
     */
    public void setVregdate(Date vregdate) {
        this.vregdate = vregdate;
    }

    /**
     * @return String return the scap
     */
    public String getScap() {
        return scap;
    }

    /**
     * @param scap the scap to set
     */
    public void setScap(String scap) {
        this.scap = scap;
    }

    /**
     * @return String return the discountper
     */
    public String getDiscountper() {
        return discountper;
    }

    /**
     * @param discountper the discountper to set
     */
    public void setDiscountper(String discountper) {
        this.discountper = discountper;
    }

    /**
     * @return String return the fueltype
     */
    public String getFueltype() {
        return fueltype;
    }

    /**
     * @param fueltype the fueltype to set
     */
    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    /**
     * @return String return the basiclibtp
     */
    public String getBasiclibtp() {
        return basiclibtp;
    }

    /**
     * @param basiclibtp the basiclibtp to set
     */
    public void setBasiclibtp(String basiclibtp) {
        this.basiclibtp = basiclibtp;
    }

    /**
     * @return String return the totalncb
     */
    public String getTotalncb() {
        return totalncb;
    }

    /**
     * @param totalncb the totalncb to set
     */
    public void setTotalncb(String totalncb) {
        this.totalncb = totalncb;
    }

    /**
     * @return String return the ll_paid
     */
    public String getLl_paid() {
        return ll_paid;
    }

    /**
     * @param ll_paid the ll_paid to set
     */
    public void setLl_paid(String ll_paid) {
        this.ll_paid = ll_paid;
    }

    /**
     * @return String return the ll_paid_other
     */
    public String getLl_paid_other() {
        return ll_paid_other;
    }

    /**
     * @param ll_paid_other the ll_paid_other to set
     */
    public void setLl_paid_other(String ll_paid_other) {
        this.ll_paid_other = ll_paid_other;
    }

    /**
     * @return String return the totaladdon
     */
    public String getTotaladdon() {
        return totaladdon;
    }

    /**
     * @param totaladdon the totaladdon to set
     */
    public void setTotaladdon(String totaladdon) {
        this.totaladdon = totaladdon;
    }

    /**
     * @return String return the pc
     */
    public String getPc() {
        return pc;
    }

    /**
     * @param pc the pc to set
     */
    public void setPc(String pc) {
        this.pc = pc;
    }

    /**
     * @return String return the chequeno
     */
    public String getChequeno() {
        return chequeno;
    }

    /**
     * @param chequeno the chequeno to set
     */
    public void setChequeno(String chequeno) {
        this.chequeno = chequeno;
    }

    /**
     * @return String return the bank_name
     */
    public String getBank_name() {
        return bank_name;
    }

    /**
     * @param bank_name the bank_name to set
     */
    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    /**
     * @return Date return the chq_date
     */
    public Date getChq_date() {
        return chq_date;
    }

    /**
     * @param chq_date the chq_date to set
     */
    public void setChq_date(Date chq_date) {
        this.chq_date = chq_date;
    }

    /**
     * @return String return the totodpre
     */
    public String getTotodpre() {
        return totodpre;
    }

    /**
     * @param totodpre the totodpre to set
     */
    public void setTotodpre(String totodpre) {
        this.totodpre = totodpre;
    }

    /**
     * @return String return the pa
     */
    public String getPa() {
        return pa;
    }

    /**
     * @param pa the pa to set
     */
    public void setPa(String pa) {
        this.pa = pa;
    }

    /**
     * @return String return the geoext
     */
    public String getGeoext() {
        return geoext;
    }

    /**
     * @param geoext the geoext to set
     */
    public void setGeoext(String geoext) {
        this.geoext = geoext;
    }

    /**
     * @return String return the imt
     */
    public String getImt() {
        return imt;
    }

    /**
     * @param imt the imt to set
     */
    public void setImt(String imt) {
        this.imt = imt;
    }

    /**
     * @return String return the paymentmode
     */
    public String getPaymentmode() {
        return paymentmode;
    }

    /**
     * @param paymentmode the paymentmode to set
     */
    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    /**
     * @return String return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return String return the extpaymentmode
     */
    public String getExtpaymentmode() {
        return extpaymentmode;
    }

    /**
     * @param extpaymentmode the extpaymentmode to set
     */
    public void setExtpaymentmode(String extpaymentmode) {
        this.extpaymentmode = extpaymentmode;
    }

    /**
     * @return String return the chequeno1
     */
    public String getChequeno1() {
        return chequeno1;
    }

    /**
     * @param chequeno1 the chequeno1 to set
     */
    public void setChequeno1(String chequeno1) {
        this.chequeno1 = chequeno1;
    }

    /**
     * @return String return the bank_name1
     */
    public String getBank_name1() {
        return bank_name1;
    }

    /**
     * @param bank_name1 the bank_name1 to set
     */
    public void setBank_name1(String bank_name1) {
        this.bank_name1 = bank_name1;
    }

    /**
     * @return Date return the chq_date1
     */
    public Date getChq_date1() {
        return chq_date1;
    }

    /**
     * @param chq_date1 the chq_date1 to set
     */
    public void setChq_date1(Date chq_date1) {
        this.chq_date1 = chq_date1;
    }

    /**
     * @return Date return the createdon
     */
    public Date getCreatedon() {
        return createdon;
    }

    /**
     * @param createdon the createdon to set
     */
    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    /**
     * @return String return the amnt1
     */
    public String getAmnt1() {
        return amnt1;
    }

    /**
     * @param amnt1 the amnt1 to set
     */
    public void setAmnt1(String amnt1) {
        this.amnt1 = amnt1;
    }

    /**
     * @return String return the amnt2
     */
    public String getAmnt2() {
        return amnt2;
    }

    /**
     * @param amnt2 the amnt2 to set
     */
    public void setAmnt2(String amnt2) {
        this.amnt2 = amnt2;
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

	public String getEng_no() {
		return eng_no;
	}

	public void setEng_no(String eng_no) {
		this.eng_no = eng_no;
	}

	public String getChe_no() {
		return che_no;
	}

	public void setChe_no(String che_no) {
		this.che_no = che_no;
	}

	public String getFin_name() {
		return fin_name;
	}

	public void setFin_name(String fin_name) {
		this.fin_name = fin_name;
	}
    
    

}
