package in.gosoftware.apimis.misapimaven.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "cmis")
public class ClaimMis {

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
    private String yom;
    private String scap;
    private String pcap;
    private String eng_no;
    private String che_no;
    private String rto_loc;
    private String fin_name;
    private String cc;
    private String ins_company;
    private String p_no;
    private String owner_type;
    private String fuel;
    private String payment_mode;
    private String reg_no;
    private String cmp_name;
    private String address_line2;
    private String landmark;
    private String comment;
    private String clintno;
    private String clmno;
    private String cltype;
    private String losstype;
    private String gdno;
    private String spotphoto;
    private String odclaimsts;
    private String odclmstamnt;
    private String dthinj;
    private String tpclaimsts;
    private String tpclmstamnt;
    private String svname;
    private String svlc;
    private String svmbno;
    private String st1;
    private String st2;
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
    private Date cldate;
    private String status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getClintno() {
		return clintno;
	}
	public void setClintno(String clintno) {
		this.clintno = clintno;
	}
	public String getClmno() {
		return clmno;
	}
	public void setClmno(String clmno) {
		this.clmno = clmno;
	}
	public String getCltype() {
		return cltype;
	}
	public void setCltype(String cltype) {
		this.cltype = cltype;
	}
	public String getLosstype() {
		return losstype;
	}
	public void setLosstype(String losstype) {
		this.losstype = losstype;
	}
	public String getGdno() {
		return gdno;
	}
	public void setGdno(String gdno) {
		this.gdno = gdno;
	}
	public String getSpotphoto() {
		return spotphoto;
	}
	public void setSpotphoto(String spotphoto) {
		this.spotphoto = spotphoto;
	}
	public String getOdclaimsts() {
		return odclaimsts;
	}
	public void setOdclaimsts(String odclaimsts) {
		this.odclaimsts = odclaimsts;
	}
	public String getOdclmstamnt() {
		return odclmstamnt;
	}
	public void setOdclmstamnt(String odclmstamnt) {
		this.odclmstamnt = odclmstamnt;
	}
	public String getDthinj() {
		return dthinj;
	}
	public void setDthinj(String dthinj) {
		this.dthinj = dthinj;
	}
	public String getTpclaimsts() {
		return tpclaimsts;
	}
	public void setTpclaimsts(String tpclaimsts) {
		this.tpclaimsts = tpclaimsts;
	}
	public String getTpclmstamnt() {
		return tpclmstamnt;
	}
	public void setTpclmstamnt(String tpclmstamnt) {
		this.tpclmstamnt = tpclmstamnt;
	}
	public String getSvname() {
		return svname;
	}
	public void setSvname(String svname) {
		this.svname = svname;
	}
	public String getSvlc() {
		return svlc;
	}
	public void setSvlc(String svlc) {
		this.svlc = svlc;
	}
	public String getSvmbno() {
		return svmbno;
	}
	public void setSvmbno(String svmbno) {
		this.svmbno = svmbno;
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
	public Date getCldate() {
		return cldate;
	}
	public void setCldate(Date cldate) {
		this.cldate = cldate;
	}
	
    
    
}
