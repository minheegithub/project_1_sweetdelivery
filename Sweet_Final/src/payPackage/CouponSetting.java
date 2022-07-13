package payPackage;
//결제 단계에서 사용가능한 쿠폰 조회시 사용하는 콤보박스에 해당클래스 arraylist 형태로 넣는다.
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

class CouponSetting {
	private int count=0; //쿠폰 종류별 개수를 세기 위함.
	private double discount_percent;
	private String couponName; //rewards 클래스에 있음.
	
	//생성자
	public CouponSetting (){}	
	public CouponSetting (double discount_percent,String couponName) {
		this.discount_percent = discount_percent;
		this.couponName = couponName;			
	}	
	
	//getter, setter
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getDiscount_percent() {
		return discount_percent;
	}
	public void setDiscount_percent(double discount_percent) {
		this.discount_percent = discount_percent;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	//쿠폰 콤보박스에 해당 형태로 들어가게 된다.
	public String toString() {
		return couponName+":"+ (int)(discount_percent*100)+"% DC ";
	}
	
}