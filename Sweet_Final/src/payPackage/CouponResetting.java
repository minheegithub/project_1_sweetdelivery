package payPackage;
//by최민희 
public class CouponResetting {

	String couponName;
	
	public CouponResetting(String couponName) {
		this.couponName = couponName;
	}
	
	public String reName() {
		String arrName[] = couponName.split(":");
		
		String strPercent = arrName[1].substring(0, 2);
		Double percent = Integer.parseInt(strPercent)*(1/100.0);
		
		return percent+","+arrName[0];
	}
}
