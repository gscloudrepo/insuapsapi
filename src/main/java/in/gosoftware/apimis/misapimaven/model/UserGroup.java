package in.gosoftware.apimis.misapimaven.model;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "mis_user_group")
public class UserGroup {

    @Id
    private String id;
    private String cid;
    private String name;
    private String ugcat;
    private String channel_partner;
    private String project;
    private boolean customercreate;
    private boolean customeredit;
    private boolean customerdelete;
    private boolean customerview;
    private boolean employeecreate;
    private boolean employeeedit;
    private boolean employeedelete;
    private boolean employeeview;
    private boolean vehiclecreate;
    private boolean vehicleedit;
    private boolean vehicledelete;
    private boolean vehicleview;
    private boolean proposalcreate;
    private boolean proposaledit;
    private boolean proposaldelete;
    private boolean proposalview;
    private boolean miscreate;
    private boolean misedit;
    private boolean misdelete;
    private boolean misview;
	private boolean claiminticreate;
	private boolean claimintiedit;
	private boolean claimintidelete;
	private boolean claimintiview;
	private boolean claimmiscreate;
	private boolean claimmisedit;
	private boolean claimmisdelete;
	private boolean claimmisview;
	private boolean helathmiscreate;
	private boolean helathmisedit;
	private boolean helathmisdelete;
	private boolean helathmisview;
	private boolean nonmotormiscreate;
	private boolean nonmotormisedit;
	private boolean nonmotormisdelete;
	private boolean nonmotormisview;
	private boolean quotecreate;
	private boolean quoteedit;
	private boolean quotedelete;
	private boolean quoteview;
    private boolean renewalcreate;
    private boolean renewaledit;
    private boolean renewaldelete;
    private boolean renewalview;
    private boolean notificationview;
    


    public UserGroup() {
        super();
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCid() {
		return cid;
	}


	public void setCid(String cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUgcat() {
		return ugcat;
	}


	public void setUgcat(String ugcat) {
		this.ugcat = ugcat;
	}


	public String getChannel_partner() {
		return channel_partner;
	}


	public void setChannel_partner(String channel_partner) {
		this.channel_partner = channel_partner;
	}


	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public boolean isCustomercreate() {
		return customercreate;
	}


	public void setCustomercreate(boolean customercreate) {
		this.customercreate = customercreate;
	}


	public boolean isCustomeredit() {
		return customeredit;
	}


	public void setCustomeredit(boolean customeredit) {
		this.customeredit = customeredit;
	}


	public boolean isCustomerdelete() {
		return customerdelete;
	}


	public void setCustomerdelete(boolean customerdelete) {
		this.customerdelete = customerdelete;
	}


	public boolean isCustomerview() {
		return customerview;
	}


	public void setCustomerview(boolean customerview) {
		this.customerview = customerview;
	}


	public boolean isEmployeecreate() {
		return employeecreate;
	}


	public void setEmployeecreate(boolean employeecreate) {
		this.employeecreate = employeecreate;
	}


	public boolean isEmployeeedit() {
		return employeeedit;
	}


	public void setEmployeeedit(boolean employeeedit) {
		this.employeeedit = employeeedit;
	}


	public boolean isEmployeedelete() {
		return employeedelete;
	}


	public void setEmployeedelete(boolean employeedelete) {
		this.employeedelete = employeedelete;
	}


	public boolean isEmployeeview() {
		return employeeview;
	}


	public void setEmployeeview(boolean employeeview) {
		this.employeeview = employeeview;
	}


	public boolean isVehiclecreate() {
		return vehiclecreate;
	}


	public void setVehiclecreate(boolean vehiclecreate) {
		this.vehiclecreate = vehiclecreate;
	}


	public boolean isVehicleedit() {
		return vehicleedit;
	}


	public void setVehicleedit(boolean vehicleedit) {
		this.vehicleedit = vehicleedit;
	}


	public boolean isVehicledelete() {
		return vehicledelete;
	}


	public void setVehicledelete(boolean vehicledelete) {
		this.vehicledelete = vehicledelete;
	}


	public boolean isVehicleview() {
		return vehicleview;
	}


	public void setVehicleview(boolean vehicleview) {
		this.vehicleview = vehicleview;
	}


	public boolean isProposalcreate() {
		return proposalcreate;
	}


	public void setProposalcreate(boolean proposalcreate) {
		this.proposalcreate = proposalcreate;
	}


	public boolean isProposaledit() {
		return proposaledit;
	}


	public void setProposaledit(boolean proposaledit) {
		this.proposaledit = proposaledit;
	}


	public boolean isProposaldelete() {
		return proposaldelete;
	}


	public void setProposaldelete(boolean proposaldelete) {
		this.proposaldelete = proposaldelete;
	}


	public boolean isProposalview() {
		return proposalview;
	}


	public void setProposalview(boolean proposalview) {
		this.proposalview = proposalview;
	}


	public boolean isMiscreate() {
		return miscreate;
	}


	public void setMiscreate(boolean miscreate) {
		this.miscreate = miscreate;
	}


	public boolean isMisedit() {
		return misedit;
	}


	public void setMisedit(boolean misedit) {
		this.misedit = misedit;
	}


	public boolean isMisdelete() {
		return misdelete;
	}


	public void setMisdelete(boolean misdelete) {
		this.misdelete = misdelete;
	}


	public boolean isMisview() {
		return misview;
	}


	public void setMisview(boolean misview) {
		this.misview = misview;
	}


	public boolean isRenewalcreate() {
		return renewalcreate;
	}


	public void setRenewalcreate(boolean renewalcreate) {
		this.renewalcreate = renewalcreate;
	}


	public boolean isRenewaledit() {
		return renewaledit;
	}


	public void setRenewaledit(boolean renewaledit) {
		this.renewaledit = renewaledit;
	}


	public boolean isRenewaldelete() {
		return renewaldelete;
	}


	public void setRenewaldelete(boolean renewaldelete) {
		this.renewaldelete = renewaldelete;
	}


	public boolean isRenewalview() {
		return renewalview;
	}


	public void setRenewalview(boolean renewalview) {
		this.renewalview = renewalview;
	}


	public boolean isNotificationview() {
		return notificationview;
	}


	public void setNotificationview(boolean notificationview) {
		this.notificationview = notificationview;
	}


	public boolean isClaiminticreate() {
		return claiminticreate;
	}


	public void setClaiminticreate(boolean claiminticreate) {
		this.claiminticreate = claiminticreate;
	}


	public boolean isClaimintiedit() {
		return claimintiedit;
	}


	public void setClaimintiedit(boolean claimintiedit) {
		this.claimintiedit = claimintiedit;
	}


	public boolean isClaimintidelete() {
		return claimintidelete;
	}


	public void setClaimintidelete(boolean claimintidelete) {
		this.claimintidelete = claimintidelete;
	}


	public boolean isClaimintiview() {
		return claimintiview;
	}


	public void setClaimintiview(boolean claimintiview) {
		this.claimintiview = claimintiview;
	}


	public boolean isClaimmiscreate() {
		return claimmiscreate;
	}


	public void setClaimmiscreate(boolean claimmiscreate) {
		this.claimmiscreate = claimmiscreate;
	}


	public boolean isClaimmisedit() {
		return claimmisedit;
	}


	public void setClaimmisedit(boolean claimmisedit) {
		this.claimmisedit = claimmisedit;
	}


	public boolean isClaimmisdelete() {
		return claimmisdelete;
	}


	public void setClaimmisdelete(boolean claimmisdelete) {
		this.claimmisdelete = claimmisdelete;
	}


	public boolean isClaimmisview() {
		return claimmisview;
	}


	public void setClaimmisview(boolean claimmisview) {
		this.claimmisview = claimmisview;
	}


	public boolean isHelathmiscreate() {
		return helathmiscreate;
	}


	public void setHelathmiscreate(boolean helathmiscreate) {
		this.helathmiscreate = helathmiscreate;
	}


	public boolean isHelathmisedit() {
		return helathmisedit;
	}


	public void setHelathmisedit(boolean helathmisedit) {
		this.helathmisedit = helathmisedit;
	}


	public boolean isHelathmisdelete() {
		return helathmisdelete;
	}


	public void setHelathmisdelete(boolean helathmisdelete) {
		this.helathmisdelete = helathmisdelete;
	}


	public boolean isHelathmisview() {
		return helathmisview;
	}


	public void setHelathmisview(boolean helathmisview) {
		this.helathmisview = helathmisview;
	}


	public boolean isNonmotormiscreate() {
		return nonmotormiscreate;
	}


	public void setNonmotormiscreate(boolean nonmotormiscreate) {
		this.nonmotormiscreate = nonmotormiscreate;
	}


	public boolean isNonmotormisedit() {
		return nonmotormisedit;
	}


	public void setNonmotormisedit(boolean nonmotormisedit) {
		this.nonmotormisedit = nonmotormisedit;
	}


	public boolean isNonmotormisdelete() {
		return nonmotormisdelete;
	}


	public void setNonmotormisdelete(boolean nonmotormisdelete) {
		this.nonmotormisdelete = nonmotormisdelete;
	}


	public boolean isNonmotormisview() {
		return nonmotormisview;
	}


	public void setNonmotormisview(boolean nonmotormisview) {
		this.nonmotormisview = nonmotormisview;
	}


	public boolean isQuotecreate() {
		return quotecreate;
	}


	public void setQuotecreate(boolean quotecreate) {
		this.quotecreate = quotecreate;
	}


	public boolean isQuoteedit() {
		return quoteedit;
	}


	public void setQuoteedit(boolean quoteedit) {
		this.quoteedit = quoteedit;
	}


	public boolean isQuotedelete() {
		return quotedelete;
	}


	public void setQuotedelete(boolean quotedelete) {
		this.quotedelete = quotedelete;
	}


	public boolean isQuoteview() {
		return quoteview;
	}


	public void setQuoteview(boolean quoteview) {
		this.quoteview = quoteview;
	}


	public UserGroup(String id, String cid, String name, String ugcat, String channel_partner, String project,
			boolean customercreate, boolean customeredit, boolean customerdelete, boolean customerview,
			boolean employeecreate, boolean employeeedit, boolean employeedelete, boolean employeeview,
			boolean vehiclecreate, boolean vehicleedit, boolean vehicledelete, boolean vehicleview,
			boolean proposalcreate, boolean proposaledit, boolean proposaldelete, boolean proposalview,
			boolean miscreate, boolean misedit, boolean misdelete, boolean misview, boolean claiminticreate,
			boolean claimintiedit, boolean claimintidelete, boolean claimintiview, boolean claimmiscreate,
			boolean claimmisedit, boolean claimmisdelete, boolean claimmisview, boolean helathmiscreate,
			boolean helathmisedit, boolean helathmisdelete, boolean helathmisview, boolean nonmotormiscreate,
			boolean nonmotormisedit, boolean nonmotormisdelete, boolean nonmotormisview, boolean quotecreate,
			boolean quoteedit, boolean quotedelete, boolean quoteview, boolean renewalcreate, boolean renewaledit,
			boolean renewaldelete, boolean renewalview, boolean notificationview) {
		super();
		this.id = id;
		this.cid = cid;
		this.name = name;
		this.ugcat = ugcat;
		this.channel_partner = channel_partner;
		this.project = project;
		this.customercreate = customercreate;
		this.customeredit = customeredit;
		this.customerdelete = customerdelete;
		this.customerview = customerview;
		this.employeecreate = employeecreate;
		this.employeeedit = employeeedit;
		this.employeedelete = employeedelete;
		this.employeeview = employeeview;
		this.vehiclecreate = vehiclecreate;
		this.vehicleedit = vehicleedit;
		this.vehicledelete = vehicledelete;
		this.vehicleview = vehicleview;
		this.proposalcreate = proposalcreate;
		this.proposaledit = proposaledit;
		this.proposaldelete = proposaldelete;
		this.proposalview = proposalview;
		this.miscreate = miscreate;
		this.misedit = misedit;
		this.misdelete = misdelete;
		this.misview = misview;
		this.claiminticreate = claiminticreate;
		this.claimintiedit = claimintiedit;
		this.claimintidelete = claimintidelete;
		this.claimintiview = claimintiview;
		this.claimmiscreate = claimmiscreate;
		this.claimmisedit = claimmisedit;
		this.claimmisdelete = claimmisdelete;
		this.claimmisview = claimmisview;
		this.helathmiscreate = helathmiscreate;
		this.helathmisedit = helathmisedit;
		this.helathmisdelete = helathmisdelete;
		this.helathmisview = helathmisview;
		this.nonmotormiscreate = nonmotormiscreate;
		this.nonmotormisedit = nonmotormisedit;
		this.nonmotormisdelete = nonmotormisdelete;
		this.nonmotormisview = nonmotormisview;
		this.quotecreate = quotecreate;
		this.quoteedit = quoteedit;
		this.quotedelete = quotedelete;
		this.quoteview = quoteview;
		this.renewalcreate = renewalcreate;
		this.renewaledit = renewaledit;
		this.renewaldelete = renewaldelete;
		this.renewalview = renewalview;
		this.notificationview = notificationview;
	}


	

    


}
