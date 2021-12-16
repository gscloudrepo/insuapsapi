package in.gosoftware.apimis.misapimaven.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "quote")
public class Quotation {

	@Id
    private String id;
    private String cmpid;
    private String producer_name;
    private String producer_code;
    private String mob_no;
    private String mail_id;
    private String first_name;
    private String middle_name;
    private String last_name;
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
    private String rto_loc;
    private String fin_name;
    private String p_type;
    private String cc;
    private String ins_company;
    private String ins_company1;
    private String ins_company2;
    private String ins_company3;
    private String p_no;
    private String reg_no;
    private String st1;
    private String st2;
    private String owner_type;
    private String fuel;
    private String cmp_name;
    private String quoteno;
    private String bundle_policy_type;
    private String curr_ncb_per;
    private String mis_tra;
    private String tra_idv;
    private String tra_no;
    private String lidv;
    private String pidv;
    private String e_acc;
    private String ne_acc;
    private String cng;
    private String anti_theft;
    private String vd;
    private String imt23;
    private String od;
    private String lltoemp;
    private String papas;
    private String gxt;
    private String restppd;
    private String preaddon;
    private String zerodep;
    private String rsa;
    private String consum;
    private String engpro;
    private String tyrcov;
    private String ncbpro;
    private String retrninv;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date p_start;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date reg_date;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date createdon;
    
    
    
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
    
    
	public String getMob_no() {
		return mob_no;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
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
	public String getReg_no() {
		return reg_no;
	}
	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
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
	public String getCmp_name() {
		return cmp_name;
	}
	public void setCmp_name(String cmp_name) {
		this.cmp_name = cmp_name;
	}
	public String getQuoteno() {
		return quoteno;
	}
	public void setQuoteno(String quoteno) {
		this.quoteno = quoteno;
	}
	public String getBundle_policy_type() {
		return bundle_policy_type;
	}
	public void setBundle_policy_type(String bundle_policy_type) {
		this.bundle_policy_type = bundle_policy_type;
	}
	public String getCurr_ncb_per() {
		return curr_ncb_per;
	}
	public void setCurr_ncb_per(String curr_ncb_per) {
		this.curr_ncb_per = curr_ncb_per;
	}
	public String getMis_tra() {
		return mis_tra;
	}
	public void setMis_tra(String mis_tra) {
		this.mis_tra = mis_tra;
	}
	public String getTra_idv() {
		return tra_idv;
	}
	public void setTra_idv(String tra_idv) {
		this.tra_idv = tra_idv;
	}
	public String getTra_no() {
		return tra_no;
	}
	public void setTra_no(String tra_no) {
		this.tra_no = tra_no;
	}
	public String getLidv() {
		return lidv;
	}
	public void setLidv(String lidv) {
		this.lidv = lidv;
	}
	public String getPidv() {
		return pidv;
	}
	public void setPidv(String pidv) {
		this.pidv = pidv;
	}
	public String getE_acc() {
		return e_acc;
	}
	public void setE_acc(String e_acc) {
		this.e_acc = e_acc;
	}
	public String getNe_acc() {
		return ne_acc;
	}
	public void setNe_acc(String ne_acc) {
		this.ne_acc = ne_acc;
	}
	public String getCng() {
		return cng;
	}
	public void setCng(String cng) {
		this.cng = cng;
	}
	public String getAnti_theft() {
		return anti_theft;
	}
	public void setAnti_theft(String anti_theft) {
		this.anti_theft = anti_theft;
	}
	public String getVd() {
		return vd;
	}
	public void setVd(String vd) {
		this.vd = vd;
	}
	public String getImt23() {
		return imt23;
	}
	public void setImt23(String imt23) {
		this.imt23 = imt23;
	}
	public String getOd() {
		return od;
	}
	public void setOd(String od) {
		this.od = od;
	}
	public String getLltoemp() {
		return lltoemp;
	}
	public void setLltoemp(String lltoemp) {
		this.lltoemp = lltoemp;
	}
	public String getPapas() {
		return papas;
	}
	public void setPapas(String papas) {
		this.papas = papas;
	}
	public String getGxt() {
		return gxt;
	}
	public void setGxt(String gxt) {
		this.gxt = gxt;
	}
	public String getRestppd() {
		return restppd;
	}
	public void setRestppd(String restppd) {
		this.restppd = restppd;
	}
	public String getPreaddon() {
		return preaddon;
	}
	public void setPreaddon(String preaddon) {
		this.preaddon = preaddon;
	}
	public String getZerodep() {
		return zerodep;
	}
	public void setZerodep(String zerodep) {
		this.zerodep = zerodep;
	}
	public String getRsa() {
		return rsa;
	}
	public void setRsa(String rsa) {
		this.rsa = rsa;
	}
	public String getConsum() {
		return consum;
	}
	public void setConsum(String consum) {
		this.consum = consum;
	}
	public String getEngpro() {
		return engpro;
	}
	public void setEngpro(String engpro) {
		this.engpro = engpro;
	}
	public String getTyrcov() {
		return tyrcov;
	}
	public void setTyrcov(String tyrcov) {
		this.tyrcov = tyrcov;
	}
	public String getNcbpro() {
		return ncbpro;
	}
	public void setNcbpro(String ncbpro) {
		this.ncbpro = ncbpro;
	}
	public String getRetrninv() {
		return retrninv;
	}
	public void setRetrninv(String retrninv) {
		this.retrninv = retrninv;
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
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
    
    

}