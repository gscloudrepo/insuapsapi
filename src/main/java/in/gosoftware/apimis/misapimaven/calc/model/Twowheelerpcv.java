package in.gosoftware.apimis.misapimaven.calc.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "twowheelerpcv")
public class Twowheelerpcv {
	
@Id
private String id;	
private String company_name;
private String customername;
private String u_reg_no;
private String regloc;
private String datee;
private String u_make;
private String u_model;
private String u_variant;
private Date u_psd;
private Date u_ped;
private String u_oc;
private String u_sc;
private String cc;
//private String fuel;
private String yom;
private String idv1;
private Double idv;
private String depre;
private String tppd;
private Double vbr;
private String zone;
private String nop;
private String av;
private String cng_yn;
private String extcng;
private String ncb_per;
private String pa;
private String ll;
private Double rtppd;
private Double other_cess_per;
private Double basic_liability;
private Double pc;
private String leadname;
private Double cng_kit;
private Double bv;
private Double cng;
private Double basic_od_premium;
private Double imt;
private String imt23_yn;
private Double bodbd;
private String doodp;
private String loodp;
private Double bodbncb;
private String no_claim;
private Double no_claim_val;
private Double net_a;
private Double total_liability;
private Double premium_before_gst;
private Double gst_cal;
private Double other_cess;
private Double premium_after_gst;
private String odt;
private String tpt;
private String agev;
private String report_name1;
private String report_name2;
private String policy_type;
private boolean zerodep;
private boolean rsa_chk;
private boolean con;
private boolean ecover;
private boolean ncbprotect;
private boolean typecover;
private boolean lossofkeys;
private boolean cuc;
private boolean sc;
private boolean roi;
private boolean mc;
private boolean dc;
private boolean rtc;
private boolean at;
private boolean vas;
private boolean imt23;
private String antitheft_yn;
private String addon;
private String valueadd;
private String total_addon;
private String antitheft_val;
private String av_val;
private String doodp_val;
private String loodp_val;
private String addon_val;
private String producer_name;
private String producer_mobile;
private String producer_email;
//private String elec_acc;
private String non_elec_acc;
private String company_logo;
private String cb1;
private String cb2;
private String cb3;
private String cb4;
private String cb5;
private String cb6;
private String cb7;
private String cb8;
private String cb9;
private String cb10;
private String cb11;
private String cb12;
private String cb13;
private String cb14;
private String cb15;
private String cb16;
private Double total_idv;
private String sysdate;
//private String yom_selected;


public String getId() {
	return id;
}
public String getSysdate() {
	return sysdate;
}
public void setSysdate(String sysdate) {
	this.sysdate = sysdate;
}
public void setId(String id) {
	this.id = id;
}
public String getCompany_name() {
	return company_name;
}
public void setCompany_name(String company_name) {
	this.company_name = company_name;
}
public String getCustomername() {
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public String getU_reg_no() {
	return u_reg_no;
}
public void setU_reg_no(String u_reg_no) {
	this.u_reg_no = u_reg_no;
}
public String getRegloc() {
	return regloc;
}
public void setRegloc(String regloc) {
	this.regloc = regloc;
}
public String getDatee() {
	return datee;
}
public void setDatee(String datee) {
	this.datee = datee;
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
public Date getU_psd() {
	return u_psd;
}
public void setU_psd(Date u_psd) {
	this.u_psd = u_psd;
}
public Date getU_ped() {
	return u_ped;
}
public void setU_ped(Date u_ped) {
	this.u_ped = u_ped;
}
public String getU_oc() {
	return u_oc;
}
public void setU_oc(String u_oc) {
	this.u_oc = u_oc;
}
public String getU_sc() {
	return u_sc;
}
public void setU_sc(String u_sc) {
	this.u_sc = u_sc;
}
public String getCc() {
	return cc;
}
public void setCc(String cc) {
	this.cc = cc;
}
//public String getFuel() {
//	return fuel;
//}
//public void setFuel(String fuel) {
//	this.fuel = fuel;
//}
public String getYom() {
	return yom;
}
public void setYom(String yom) {
	this.yom = yom;
}
public String getIdv1() {
	return idv1;
}
public void setIdv1(String idv1) {
	this.idv1 = idv1;
}
public Double getIdv() {
	return idv;
}
public void setIdv(Double idv) {
	this.idv = idv;
}
public String getDepre() {
	return depre;
}
public void setDepre(String depre) {
	this.depre = depre;
}
public String getTppd() {
	return tppd;
}
public void setTppd(String tppd) {
	this.tppd = tppd;
}
public Double getVbr() {
	return vbr;
}
public void setVbr(Double vbr) {
	this.vbr = vbr;
}
public String getZone() {
	return zone;
}
public void setZone(String zone) {
	this.zone = zone;
}
public String getNop() {
	return nop;
}
public void setNop(String nop) {
	this.nop = nop;
}
public String getAv() {
	return av;
}
public void setAv(String av) {
	this.av = av;
}
public String getCng_yn() {
	return cng_yn;
}
public void setCng_yn(String cng_yn) {
	this.cng_yn = cng_yn;
}
public String getExtcng() {
	return extcng;
}
public void setExtcng(String extcng) {
	this.extcng = extcng;
}
public String getNcb_per() {
	return ncb_per;
}
public void setNcb_per(String ncb_per) {
	this.ncb_per = ncb_per;
}
public String getPa() {
	return pa;
}
public void setPa(String pa) {
	this.pa = pa;
}
public String getLl() {
	return ll;
}
public void setLl(String ll) {
	this.ll = ll;
}
public Double getRtppd() {
	return rtppd;
}
public void setRtppd(Double rtppd) {
	this.rtppd = rtppd;
}
public Double getOther_cess_per() {
	return other_cess_per;
}
public void setOther_cess_per(Double other_cess_per) {
	this.other_cess_per = other_cess_per;
}
public Double getBasic_liability() {
	return basic_liability;
}
public void setBasic_liability(Double basic_liability) {
	this.basic_liability = basic_liability;
}
public Double getPc() {
	return pc;
}
public void setPc(Double pc) {
	this.pc = pc;
}
public String getLeadname() {
	return leadname;
}
public void setLeadname(String leadname) {
	this.leadname = leadname;
}
public Double getCng_kit() {
	return cng_kit;
}
public void setCng_kit(Double cng_kit) {
	this.cng_kit = cng_kit;
}
public Double getBv() {
	return bv;
}
public void setBv(Double bv) {
	this.bv = bv;
}
public Double getCng() {
	return cng;
}
public void setCng(Double cng) {
	this.cng = cng;
}
public Double getBasic_od_premium() {
	return basic_od_premium;
}
public void setBasic_od_premium(Double basic_od_premium) {
	this.basic_od_premium = basic_od_premium;
}
public Double getImt() {
	return imt;
}
public void setImt(Double imt) {
	this.imt = imt;
}
public String getImt23_yn() {
	return imt23_yn;
}
public void setImt23_yn(String imt23_yn) {
	this.imt23_yn = imt23_yn;
}
public Double getBodbd() {
	return bodbd;
}
public void setBodbd(Double bodbd) {
	this.bodbd = bodbd;
}
public String getDoodp() {
	return doodp;
}
public void setDoodp(String doodp) {
	this.doodp = doodp;
}
public String getLoodp() {
	return loodp;
}
public void setLoodp(String loodp) {
	this.loodp = loodp;
}
public Double getBodbncb() {
	return bodbncb;
}
public void setBodbncb(Double bodbncb) {
	this.bodbncb = bodbncb;
}
public String getNo_claim() {
	return no_claim;
}
public void setNo_claim(String no_claim) {
	this.no_claim = no_claim;
}
public Double getNo_claim_val() {
	return no_claim_val;
}
public void setNo_claim_val(Double no_claim_val) {
	this.no_claim_val = no_claim_val;
}
public Double getNet_a() {
	return net_a;
}
public void setNet_a(Double net_a) {
	this.net_a = net_a;
}
public Double getTotal_liability() {
	return total_liability;
}
public void setTotal_liability(Double total_liability) {
	this.total_liability = total_liability;
}
public Double getPremium_before_gst() {
	return premium_before_gst;
}
public void setPremium_before_gst(Double premium_before_gst) {
	this.premium_before_gst = premium_before_gst;
}
public Double getGst_cal() {
	return gst_cal;
}
public void setGst_cal(Double gst_cal) {
	this.gst_cal = gst_cal;
}
public Double getOther_cess() {
	return other_cess;
}
public void setOther_cess(Double other_cess) {
	this.other_cess = other_cess;
}
public Double getPremium_after_gst() {
	return premium_after_gst;
}
public void setPremium_after_gst(Double premium_after_gst) {
	this.premium_after_gst = premium_after_gst;
}
public String getOdt() {
	return odt;
}
public void setOdt(String odt) {
	this.odt = odt;
}
public String getTpt() {
	return tpt;
}
public void setTpt(String tpt) {
	this.tpt = tpt;
}
public String getAgev() {
	return agev;
}
public void setAgev(String agev) {
	this.agev = agev;
}
public String getReport_name1() {
	return report_name1;
}
public void setReport_name1(String report_name1) {
	this.report_name1 = report_name1;
}
public String getReport_name2() {
	return report_name2;
}
public void setReport_name2(String report_name2) {
	this.report_name2 = report_name2;
}
public String getPolicy_type() {
	return policy_type;
}
public void setPolicy_type(String policy_type) {
	this.policy_type = policy_type;
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
public boolean isCon() {
	return con;
}
public void setCon(boolean con) {
	this.con = con;
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
public boolean isCuc() {
	return cuc;
}
public void setCuc(boolean cuc) {
	this.cuc = cuc;
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
public String getAntitheft_yn() {
	return antitheft_yn;
}
public void setAntitheft_yn(String antitheft_yn) {
	this.antitheft_yn = antitheft_yn;
}
public String getAddon() {
	return addon;
}
public void setAddon(String addon) {
	this.addon = addon;
}
public String getValueadd() {
	return valueadd;
}
public void setValueadd(String valueadd) {
	this.valueadd = valueadd;
}
public String getTotal_addon() {
	return total_addon;
}
public void setTotal_addon(String total_addon) {
	this.total_addon = total_addon;
}

public String getAntitheft_val() {
	return antitheft_val;
}
public void setAntitheft_val(String antitheft_val) {
	this.antitheft_val = antitheft_val;
}
public String getAv_val() {
	return av_val;
}
public void setAv_val(String av_val) {
	this.av_val = av_val;
}
public String getDoodp_val() {
	return doodp_val;
}
public void setDoodp_val(String doodp_val) {
	this.doodp_val = doodp_val;
}
public String getLoodp_val() {
	return loodp_val;
}
public void setLoodp_val(String loodp_val) {
	this.loodp_val = loodp_val;
}
public String getAddon_val() {
	return addon_val;
}
public void setAddon_val(String addon_val) {
	this.addon_val = addon_val;
}
public String getProducer_name() {
	return producer_name;
}
public void setProducer_name(String producer_name) {
	this.producer_name = producer_name;
}
public String getProducer_mobile() {
	return producer_mobile;
}
public void setProducer_mobile(String producer_mobile) {
	this.producer_mobile = producer_mobile;
}
public String getProducer_email() {
	return producer_email;
}
public void setProducer_email(String producer_email) {
	this.producer_email = producer_email;
}
//public String getElec_acc() {
//	return elec_acc;
//}
//public void setElec_acc(String elec_acc) {
//	this.elec_acc = elec_acc;
//}
public String getNon_elec_acc() {
	return non_elec_acc;
}
public void setNon_elec_acc(String non_elec_acc) {
	this.non_elec_acc = non_elec_acc;
}
public String getCompany_logo() {
	return company_logo;
}
public void setCompany_logo(String company_logo) {
	this.company_logo = company_logo;
}
public String getCb1() {
	return cb1;
}
public void setCb1(String cb1) {
	this.cb1 = cb1;
}
public String getCb2() {
	return cb2;
}
public void setCb2(String cb2) {
	this.cb2 = cb2;
}
public String getCb3() {
	return cb3;
}
public void setCb3(String cb3) {
	this.cb3 = cb3;
}
public String getCb4() {
	return cb4;
}
public void setCb4(String cb4) {
	this.cb4 = cb4;
}
public String getCb5() {
	return cb5;
}
public void setCb5(String cb5) {
	this.cb5 = cb5;
}
public String getCb6() {
	return cb6;
}
public void setCb6(String cb6) {
	this.cb6 = cb6;
}
public String getCb7() {
	return cb7;
}
public void setCb7(String cb7) {
	this.cb7 = cb7;
}
public String getCb8() {
	return cb8;
}
public void setCb8(String cb8) {
	this.cb8 = cb8;
}
public String getCb9() {
	return cb9;
}
public void setCb9(String cb9) {
	this.cb9 = cb9;
}
public String getCb10() {
	return cb10;
}
public void setCb10(String cb10) {
	this.cb10 = cb10;
}
public String getCb11() {
	return cb11;
}
public void setCb11(String cb11) {
	this.cb11 = cb11;
}
public String getCb12() {
	return cb12;
}
public void setCb12(String cb12) {
	this.cb12 = cb12;
}
public String getCb13() {
	return cb13;
}
public void setCb13(String cb13) {
	this.cb13 = cb13;
}
public String getCb14() {
	return cb14;
}
public void setCb14(String cb14) {
	this.cb14 = cb14;
}
public String getCb15() {
	return cb15;
}
public void setCb15(String cb15) {
	this.cb15 = cb15;
}
public String getCb16() {
	return cb16;
}
public void setCb16(String cb16) {
	this.cb16 = cb16;
}

public Double getTotal_idv() {
	return total_idv;
}
public void setTotal_idv(Double total_idv) {
	this.total_idv = total_idv;
}
//public String getYom_selected() {
//	return yom_selected;
//}
//public void setYom_selected(String yom_selected) {
//	this.yom_selected = yom_selected;
//}







}

