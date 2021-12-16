package in.gosoftware.apimis.misapimaven.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "healthmis")
public class HealthMis {
	@Id
    private String id ;
    private String cmpid ;
    private String poposarname ;
    private String area ;
    private String mobileno ;
    private String whatsappno ;
    private String alternateno ;
    private String emailid ;
    private String owner_type ;
    private String ins_company ;
    private String p_no ;
    private String plan ;
    private String fpremium ;
    private String manager ;
    private String insurednameone ;
    private String genderone ;
    private String ageone ;
    private String relone ;
    private String suminsuredone ;
    private String bonusone ;
    private String premiumone ;
    private String insurednametwo ;
    private String gendertwo ;
    private String agetwo ;
    private String reltwo ;
    private String suminsuredtwo ;
    private String bonustwo ;
    private String premiumtwo ;
    private String insurednamethree ;
    private String genderthree ;
    private String agethree ;
    private String relthree ;
    private String suminsuredthree ;
    private String bonusthree ;
    private String premiumthree ;
    private String insurednamefour ;
    private String genderfour ;
    private String agefour ;
    private String relfour ;
    private String suminsuredfour ;
    private String bonusfour ;
    private String premiumfour ;
    private String insurednamefive ;
    private String genderfive ;
    private String agefive ;
    private String relfive ;
    private String suminsuredfive ;
    private String bonusfive ;
    private String premiumfive ;
    private String insurednamesix ;
    private String gendersix ;
    private String agesix ;
    private String relsix ;
    private String suminsuredsix ;
    private String bonussix ;
    private String premiumsix ;
    private String payment_mode ;
    private String cheq_dd_no ;
    private String bank ;
    private String amount ;
    private String business ;
    private String callby ;
    private String pickupby ;
    private String agentcode ;
    private String agentname ;
    private String agentloc ;
    private String cpcode ;
    private String cpname ;
    private String cploc ;
    private String payoutamount ;
    private String payoutrelease ;
    private String payoutmode ;
    private String policydeliv ;
    private String cashback ;
    private String comments ;
    private String customerreview ;
    private String state ;
    private String pin ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date che_date ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date psd ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ped ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dobone ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dobtwo ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dobthree ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dobfour ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dobfive ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dobsix ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date payoutdate ;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdon;
    
    private String remark;
    private String remarks;
    
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCmpid() {
		return cmpid;
	}
	public void setCmpid(String cmpid) {
		this.cmpid = cmpid;
	}
	public String getPoposarname() {
		return poposarname;
	}
	public void setPoposarname(String poposarname) {
		this.poposarname = poposarname;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getWhatsappno() {
		return whatsappno;
	}
	public void setWhatsappno(String whatsappno) {
		this.whatsappno = whatsappno;
	}
	public String getAlternateno() {
		return alternateno;
	}
	public void setAlternateno(String alternateno) {
		this.alternateno = alternateno;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getOwner_type() {
		return owner_type;
	}
	public void setOwner_type(String owner_type) {
		this.owner_type = owner_type;
	}
	public String getIns_company() {
		return ins_company;
	}
	public void setIns_company(String ins_company) {
		this.ins_company = ins_company;
	}
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getFpremium() {
		return fpremium;
	}
	public void setFpremium(String fpremium) {
		this.fpremium = fpremium;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getInsurednameone() {
		return insurednameone;
	}
	public void setInsurednameone(String insurednameone) {
		this.insurednameone = insurednameone;
	}
	public String getGenderone() {
		return genderone;
	}
	public void setGenderone(String genderone) {
		this.genderone = genderone;
	}
	public String getAgeone() {
		return ageone;
	}
	public void setAgeone(String ageone) {
		this.ageone = ageone;
	}
	public String getRelone() {
		return relone;
	}
	public void setRelone(String relone) {
		this.relone = relone;
	}
	public String getSuminsuredone() {
		return suminsuredone;
	}
	public void setSuminsuredone(String suminsuredone) {
		this.suminsuredone = suminsuredone;
	}
	public String getBonusone() {
		return bonusone;
	}
	public void setBonusone(String bonusone) {
		this.bonusone = bonusone;
	}
	public String getPremiumone() {
		return premiumone;
	}
	public void setPremiumone(String premiumone) {
		this.premiumone = premiumone;
	}
	public String getInsurednametwo() {
		return insurednametwo;
	}
	public void setInsurednametwo(String insurednametwo) {
		this.insurednametwo = insurednametwo;
	}
	public String getGendertwo() {
		return gendertwo;
	}
	public void setGendertwo(String gendertwo) {
		this.gendertwo = gendertwo;
	}
	public String getAgetwo() {
		return agetwo;
	}
	public void setAgetwo(String agetwo) {
		this.agetwo = agetwo;
	}
	public String getReltwo() {
		return reltwo;
	}
	public void setReltwo(String reltwo) {
		this.reltwo = reltwo;
	}
	public String getSuminsuredtwo() {
		return suminsuredtwo;
	}
	public void setSuminsuredtwo(String suminsuredtwo) {
		this.suminsuredtwo = suminsuredtwo;
	}
	public String getBonustwo() {
		return bonustwo;
	}
	public void setBonustwo(String bonustwo) {
		this.bonustwo = bonustwo;
	}
	public String getPremiumtwo() {
		return premiumtwo;
	}
	public void setPremiumtwo(String premiumtwo) {
		this.premiumtwo = premiumtwo;
	}
	public String getInsurednamethree() {
		return insurednamethree;
	}
	public void setInsurednamethree(String insurednamethree) {
		this.insurednamethree = insurednamethree;
	}
	public String getGenderthree() {
		return genderthree;
	}
	public void setGenderthree(String genderthree) {
		this.genderthree = genderthree;
	}
	public String getAgethree() {
		return agethree;
	}
	public void setAgethree(String agethree) {
		this.agethree = agethree;
	}
	public String getRelthree() {
		return relthree;
	}
	public void setRelthree(String relthree) {
		this.relthree = relthree;
	}
	public String getSuminsuredthree() {
		return suminsuredthree;
	}
	public void setSuminsuredthree(String suminsuredthree) {
		this.suminsuredthree = suminsuredthree;
	}
	public String getBonusthree() {
		return bonusthree;
	}
	public void setBonusthree(String bonusthree) {
		this.bonusthree = bonusthree;
	}
	public String getPremiumthree() {
		return premiumthree;
	}
	public void setPremiumthree(String premiumthree) {
		this.premiumthree = premiumthree;
	}
	public String getInsurednamefour() {
		return insurednamefour;
	}
	public void setInsurednamefour(String insurednamefour) {
		this.insurednamefour = insurednamefour;
	}
	public String getGenderfour() {
		return genderfour;
	}
	public void setGenderfour(String genderfour) {
		this.genderfour = genderfour;
	}
	public String getAgefour() {
		return agefour;
	}
	public void setAgefour(String agefour) {
		this.agefour = agefour;
	}
	public String getRelfour() {
		return relfour;
	}
	public void setRelfour(String relfour) {
		this.relfour = relfour;
	}
	public String getSuminsuredfour() {
		return suminsuredfour;
	}
	public void setSuminsuredfour(String suminsuredfour) {
		this.suminsuredfour = suminsuredfour;
	}
	public String getBonusfour() {
		return bonusfour;
	}
	public void setBonusfour(String bonusfour) {
		this.bonusfour = bonusfour;
	}
	public String getPremiumfour() {
		return premiumfour;
	}
	public void setPremiumfour(String premiumfour) {
		this.premiumfour = premiumfour;
	}
	public String getInsurednamefive() {
		return insurednamefive;
	}
	public void setInsurednamefive(String insurednamefive) {
		this.insurednamefive = insurednamefive;
	}
	public String getGenderfive() {
		return genderfive;
	}
	public void setGenderfive(String genderfive) {
		this.genderfive = genderfive;
	}
	public String getAgefive() {
		return agefive;
	}
	public void setAgefive(String agefive) {
		this.agefive = agefive;
	}
	public String getRelfive() {
		return relfive;
	}
	public void setRelfive(String relfive) {
		this.relfive = relfive;
	}
	public String getSuminsuredfive() {
		return suminsuredfive;
	}
	public void setSuminsuredfive(String suminsuredfive) {
		this.suminsuredfive = suminsuredfive;
	}
	public String getBonusfive() {
		return bonusfive;
	}
	public void setBonusfive(String bonusfive) {
		this.bonusfive = bonusfive;
	}
	public String getPremiumfive() {
		return premiumfive;
	}
	public void setPremiumfive(String premiumfive) {
		this.premiumfive = premiumfive;
	}
	public String getInsurednamesix() {
		return insurednamesix;
	}
	public void setInsurednamesix(String insurednamesix) {
		this.insurednamesix = insurednamesix;
	}
	public String getGendersix() {
		return gendersix;
	}
	public void setGendersix(String gendersix) {
		this.gendersix = gendersix;
	}
	public String getAgesix() {
		return agesix;
	}
	public void setAgesix(String agesix) {
		this.agesix = agesix;
	}
	public String getRelsix() {
		return relsix;
	}
	public void setRelsix(String relsix) {
		this.relsix = relsix;
	}
	public String getSuminsuredsix() {
		return suminsuredsix;
	}
	public void setSuminsuredsix(String suminsuredsix) {
		this.suminsuredsix = suminsuredsix;
	}
	public String getBonussix() {
		return bonussix;
	}
	public void setBonussix(String bonussix) {
		this.bonussix = bonussix;
	}
	public String getPremiumsix() {
		return premiumsix;
	}
	public void setPremiumsix(String premiumsix) {
		this.premiumsix = premiumsix;
	}
	public String getPayment_mode() {
		return payment_mode;
	}
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	public String getCheq_dd_no() {
		return cheq_dd_no;
	}
	public void setCheq_dd_no(String cheq_dd_no) {
		this.cheq_dd_no = cheq_dd_no;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getCallby() {
		return callby;
	}
	public void setCallby(String callby) {
		this.callby = callby;
	}
	public String getPickupby() {
		return pickupby;
	}
	public void setPickupby(String pickupby) {
		this.pickupby = pickupby;
	}
	public String getAgentcode() {
		return agentcode;
	}
	public void setAgentcode(String agentcode) {
		this.agentcode = agentcode;
	}
	public String getAgentname() {
		return agentname;
	}
	public void setAgentname(String agentname) {
		this.agentname = agentname;
	}
	public String getAgentloc() {
		return agentloc;
	}
	public void setAgentloc(String agentloc) {
		this.agentloc = agentloc;
	}
	public String getCpcode() {
		return cpcode;
	}
	public void setCpcode(String cpcode) {
		this.cpcode = cpcode;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public String getCploc() {
		return cploc;
	}
	public void setCploc(String cploc) {
		this.cploc = cploc;
	}
	public String getPayoutamount() {
		return payoutamount;
	}
	public void setPayoutamount(String payoutamount) {
		this.payoutamount = payoutamount;
	}
	public String getPayoutrelease() {
		return payoutrelease;
	}
	public void setPayoutrelease(String payoutrelease) {
		this.payoutrelease = payoutrelease;
	}
	public String getPayoutmode() {
		return payoutmode;
	}
	public void setPayoutmode(String payoutmode) {
		this.payoutmode = payoutmode;
	}
	public String getPolicydeliv() {
		return policydeliv;
	}
	public void setPolicydeliv(String policydeliv) {
		this.policydeliv = policydeliv;
	}
	public String getCashback() {
		return cashback;
	}
	public void setCashback(String cashback) {
		this.cashback = cashback;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCustomerreview() {
		return customerreview;
	}
	public void setCustomerreview(String customerreview) {
		this.customerreview = customerreview;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Date getChe_date() {
		return che_date;
	}
	public void setChe_date(Date che_date) {
		this.che_date = che_date;
	}
	public Date getPsd() {
		return psd;
	}
	public void setPsd(Date psd) {
		this.psd = psd;
	}
	public Date getPed() {
		return ped;
	}
	public void setPed(Date ped) {
		this.ped = ped;
	}
	public Date getDobone() {
		return dobone;
	}
	public void setDobone(Date dobone) {
		this.dobone = dobone;
	}
	public Date getDobtwo() {
		return dobtwo;
	}
	public void setDobtwo(Date dobtwo) {
		this.dobtwo = dobtwo;
	}
	public Date getDobthree() {
		return dobthree;
	}
	public void setDobthree(Date dobthree) {
		this.dobthree = dobthree;
	}
	public Date getDobfour() {
		return dobfour;
	}
	public void setDobfour(Date dobfour) {
		this.dobfour = dobfour;
	}
	public Date getDobfive() {
		return dobfive;
	}
	public void setDobfive(Date dobfive) {
		this.dobfive = dobfive;
	}
	public Date getDobsix() {
		return dobsix;
	}
	public void setDobsix(Date dobsix) {
		this.dobsix = dobsix;
	}
	public Date getPayoutdate() {
		return payoutdate;
	}
	public void setPayoutdate(Date payoutdate) {
		this.payoutdate = payoutdate;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	


}
