package in.gosoftware.apimis.misapimaven.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "cinfo")
public class ClaimInfo {

	@Id
    private String id;
    private String cmpid;
    private String producer_name;
    private String producer_code;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String mob_no;
    private String alt_no;
    private String mail_id;
    private String address_line1;
    private String city;
    private String state;
    private String pin;
    private String gender;
    private String mat_status;
    private String gst;
    private String name;
    private String rel_n;
    private String policy_type;
    private String policy_module;
    private String vehicle_type;
    private String ncb_per;
    private String u_make;
    private String u_model;
    private String u_variant;
    private String vspeed;
    private String yom;
    private String scap;
    private String pcap;
    private String eng_no;
    private String che_no;
    private String rto_loc;
    private String fin_name;
    private String p_type;
    private String cc;
    private String ins_company;
    private String ins_company1;
    private String ins_company2;
    private String ins_company3;
    private String p_no;
    private String owner_type;
    private String fuel;
    private String payment_mode;
    private String reg_no;
    private String cmp_name;
    private String address_line2;
    private String landmark;
    private String comment;
    private String claimno;
    private String losstime;
    private String losslocation;
    private String lcity;
    private String lstate;
    private String lpin;
    private String beforeacc;
    private String puoposeacc;
    private String natureacc;
    private String peopleacc;
    private String acctime;
    private String losstype;
    private String preport;
    private String namepolicestn;
    private String gdno;
    private String dname;
    private String dlastname;
    private String fathername;
    private String dal1;
    private String dal2;
    private String dcity;
    private String dpcode;
    private String dstate;
    private String licn;
    private String issuerto;
    private String licdrive;
    private String st1;
    private String st2;
    private String dmob_no;
    private String dalt_no;
    private String lictype;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob_n;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date p_start;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date reg_date;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ped;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date od_date;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date tp_date;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdon;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date lossdate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date ddob;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date licnissdate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date licnexp;

    private String cltype;
    	
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
	public String getCltype() {
		return cltype;
	}

	public void setCltype(String cltype) {
		this.cltype = cltype;
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

	public String getProducer_name() {
		return producer_name;
	}

	public void setProducer_name(String producer_name) {
		this.producer_name = producer_name;
	}

	public String getProducer_code() {
		return producer_code;
	}

	public void setProducer_code(String producer_code) {
		this.producer_code = producer_code;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMob_no() {
		return mob_no;
	}

	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}

	public String getAlt_no() {
		return alt_no;
	}

	public void setAlt_no(String alt_no) {
		this.alt_no = alt_no;
	}

	public String getMail_id() {
		return mail_id;
	}

	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMat_status() {
		return mat_status;
	}

	public void setMat_status(String mat_status) {
		this.mat_status = mat_status;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRel_n() {
		return rel_n;
	}

	public void setRel_n(String rel_n) {
		this.rel_n = rel_n;
	}

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

	public String getPolicy_module() {
		return policy_module;
	}

	public void setPolicy_module(String policy_module) {
		this.policy_module = policy_module;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getNcb_per() {
		return ncb_per;
	}

	public void setNcb_per(String ncb_per) {
		this.ncb_per = ncb_per;
	}

	public String getU_make() {
		return u_make;
	}

	public void setU_make(String u_make) {
		this.u_make = u_make;
	}

	public String getU_model() {
		return u_model;
	}

	public void setU_model(String u_model) {
		this.u_model = u_model;
	}

	public String getU_variant() {
		return u_variant;
	}

	public void setU_variant(String u_variant) {
		this.u_variant = u_variant;
	}

	public String getYom() {
		return yom;
	}

	public void setYom(String yom) {
		this.yom = yom;
	}

	public String getScap() {
		return scap;
	}

	public void setScap(String scap) {
		this.scap = scap;
	}

	public String getPcap() {
		return pcap;
	}

	public void setPcap(String pcap) {
		this.pcap = pcap;
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

	public String getRto_loc() {
		return rto_loc;
	}

	public void setRto_loc(String rto_loc) {
		this.rto_loc = rto_loc;
	}

	public String getFin_name() {
		return fin_name;
	}

	public void setFin_name(String fin_name) {
		this.fin_name = fin_name;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getIns_company() {
		return ins_company;
	}

	public void setIns_company(String ins_company) {
		this.ins_company = ins_company;
	}

	public String getIns_company1() {
		return ins_company1;
	}

	public void setIns_company1(String ins_company1) {
		this.ins_company1 = ins_company1;
	}

	public String getIns_company2() {
		return ins_company2;
	}

	public void setIns_company2(String ins_company2) {
		this.ins_company2 = ins_company2;
	}

	public String getIns_company3() {
		return ins_company3;
	}

	public void setIns_company3(String ins_company3) {
		this.ins_company3 = ins_company3;
	}

	public String getP_no() {
		return p_no;
	}

	public void setP_no(String p_no) {
		this.p_no = p_no;
	}

	public String getOwner_type() {
		return owner_type;
	}

	public void setOwner_type(String owner_type) {
		this.owner_type = owner_type;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public String getCmp_name() {
		return cmp_name;
	}

	public void setCmp_name(String cmp_name) {
		this.cmp_name = cmp_name;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getClaimno() {
		return claimno;
	}

	public void setClaimno(String claimno) {
		this.claimno = claimno;
	}

	public String getLosstime() {
		return losstime;
	}

	public void setLosstime(String losstime) {
		this.losstime = losstime;
	}

	public String getLosslocation() {
		return losslocation;
	}

	public void setLosslocation(String losslocation) {
		this.losslocation = losslocation;
	}

	public String getLcity() {
		return lcity;
	}

	public void setLcity(String lcity) {
		this.lcity = lcity;
	}

	public String getLstate() {
		return lstate;
	}

	public void setLstate(String lstate) {
		this.lstate = lstate;
	}

	public String getLpin() {
		return lpin;
	}

	public void setLpin(String lpin) {
		this.lpin = lpin;
	}

	
	public String getVspeed() {
		return vspeed;
	}

	public void setVspeed(String vspeed) {
		this.vspeed = vspeed;
	}

	public String getBeforeacc() {
		return beforeacc;
	}

	public void setBeforeacc(String beforeacc) {
		this.beforeacc = beforeacc;
	}

	public String getPuoposeacc() {
		return puoposeacc;
	}

	public void setPuoposeacc(String puoposeacc) {
		this.puoposeacc = puoposeacc;
	}

	public String getNatureacc() {
		return natureacc;
	}

	public void setNatureacc(String natureacc) {
		this.natureacc = natureacc;
	}

	public String getPeopleacc() {
		return peopleacc;
	}

	public void setPeopleacc(String peopleacc) {
		this.peopleacc = peopleacc;
	}

	public String getAcctime() {
		return acctime;
	}

	public void setAcctime(String acctime) {
		this.acctime = acctime;
	}

	public String getLosstype() {
		return losstype;
	}

	public void setLosstype(String losstype) {
		this.losstype = losstype;
	}

	public String getPreport() {
		return preport;
	}

	public void setPreport(String preport) {
		this.preport = preport;
	}

	public String getNamepolicestn() {
		return namepolicestn;
	}

	public void setNamepolicestn(String namepolicestn) {
		this.namepolicestn = namepolicestn;
	}

	public String getGdno() {
		return gdno;
	}

	public void setGdno(String gdno) {
		this.gdno = gdno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDlastname() {
		return dlastname;
	}

	public void setDlastname(String dlastname) {
		this.dlastname = dlastname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getDal1() {
		return dal1;
	}

	public void setDal1(String dal1) {
		this.dal1 = dal1;
	}

	public String getDal2() {
		return dal2;
	}

	public void setDal2(String dal2) {
		this.dal2 = dal2;
	}

	public String getDcity() {
		return dcity;
	}

	public void setDcity(String dcity) {
		this.dcity = dcity;
	}

	public String getDpcode() {
		return dpcode;
	}

	public void setDpcode(String dpcode) {
		this.dpcode = dpcode;
	}

	public String getDstate() {
		return dstate;
	}

	public void setDstate(String dstate) {
		this.dstate = dstate;
	}

	public String getLicn() {
		return licn;
	}

	public void setLicn(String licn) {
		this.licn = licn;
	}

	public String getIssuerto() {
		return issuerto;
	}

	public void setIssuerto(String issuerto) {
		this.issuerto = issuerto;
	}

	public String getLicdrive() {
		return licdrive;
	}

	public void setLicdrive(String licdrive) {
		this.licdrive = licdrive;
	}

	public String getSt1() {
		return st1;
	}

	public void setSt1(String st1) {
		this.st1 = st1;
	}

	public String getSt2() {
		return st2;
	}

	public void setSt2(String st2) {
		this.st2 = st2;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDob_n() {
		return dob_n;
	}

	public void setDob_n(Date dob_n) {
		this.dob_n = dob_n;
	}

	public Date getP_start() {
		return p_start;
	}

	public void setP_start(Date p_start) {
		this.p_start = p_start;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getPed() {
		return ped;
	}

	public void setPed(Date ped) {
		this.ped = ped;
	}

	public Date getOd_date() {
		return od_date;
	}

	public void setOd_date(Date od_date) {
		this.od_date = od_date;
	}

	public Date getTp_date() {
		return tp_date;
	}

	public void setTp_date(Date tp_date) {
		this.tp_date = tp_date;
	}

	public Date getCreatedon() {
		return createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	public Date getLossdate() {
		return lossdate;
	}

	public void setLossdate(Date lossdate) {
		this.lossdate = lossdate;
	}

	public Date getDdob() {
		return ddob;
	}

	public void setDdob(Date ddob) {
		this.ddob = ddob;
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

	public String getDmob_no() {
		return dmob_no;
	}

	public void setDmob_no(String dmob_no) {
		this.dmob_no = dmob_no;
	}

	public String getDalt_no() {
		return dalt_no;
	}

	public void setDalt_no(String dalt_no) {
		this.dalt_no = dalt_no;
	}

	public String getLictype() {
		return lictype;
	}

	public void setLictype(String lictype) {
		this.lictype = lictype;
	}

	public ClaimInfo() {
		
	}


    
}