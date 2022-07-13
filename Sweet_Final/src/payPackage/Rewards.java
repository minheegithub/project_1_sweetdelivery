package payPackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//쿠폰, 포인트 관리 클래스.
public class Rewards {
	
	//???????????????필드랑 생성자는 없어도 되는것 같다.
	private int point; //포인트 
	
	private double discount; //할인 쿠폰에 적용될 할인율
	private String couponName; //할인 쿠폰의 이름 
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	
	//생성자 오버로딩
	public Rewards(int point) {
		this.point = point;
	}
	
	public Rewards(double discount, String couponName) {
		this.discount = discount;
		this.couponName = couponName;
	}
	
	//toString-- 쿠폰 전용 
	public String toString() {
		return discount +","+ couponName;
	}
	
	//메서드 오버로딩- 포인트---------------------------------------------------------------------------------------//
	public void WriteToFile(int point,String id) {
	//읽기- 읽어서 기존 값에 받아온 값을 더해야 한다.
	 String path =".\\src\\resource\\rewards\\"+id+"Point.txt";
//	 String path =".\\src\\resource\\rewards\\point.txt";
	 File file = new File(path);
	 
	 //기존 파일이 존재하지 않는경우 파일 생성, 아이디별로 포인트를 저장할 파일을 따로 만든다.
	 if(!file.exists()) {
		 try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }
	 int newValue=0;
	 int existingValue;
	 DataInputStream dis = null;
	 try {
		 	dis = new DataInputStream(new FileInputStream(file));
		 		
	 		String value = dis.readLine();
	 		//저장된 포인트가 없을경우 에러를 방지하기 위해 0을 임의로 넣음 
	 		if(value == null) {
	 			value = "0";
	 		}
			System.out.println("기존 포인트 : "+value);
			existingValue = Integer.parseInt(value); //문자열을 정수로 바꿈.
			newValue = existingValue+ point; //기존 값과 합쳤음.

	 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	//쓰기
	FileWriter writer = null;
	String message = String.valueOf(newValue); //새롭게 계산한 값을 파일에 쓰기 위해 문자열로 바꾸었다.
	message.trim(); //빈줄 지우기 위해서.
	try {
		//true는 기존 내용에 이어서 쓰는 것, 기존내용을 없애고 새로 쓰려면 false .-> 매번 값을 받을 때마다 갱신된다.
		writer = new FileWriter(path,false); 
//		writer.append(message+"\r\n");
		writer.write(message);
		writer.flush();
		
		String showPoint = point + "적립, 총 "+newValue+" 포인트를 보유하고 계십니다.";
		System.out.println(showPoint);
	}catch(IOException e) {
		e.printStackTrace();
	}finally {
		try {
			if(writer !=null) writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	}
	
	//메서드 오버로딩- 쿠폰---------------------------------------------------------------------------------------//
	public void WriteToFile(double discount , String CouponName ,String id) {
		
		String path = ".\\src\\resource\\rewards\\"+id+"Coupon.txt";
//		String path = ".\\src\\resource\\rewards\\coupon.txt";
		FileWriter writer = null;
		BufferedWriter bw = null;
		String message = String.valueOf(discount); //실수로 받은 할인율 값을 문자열로 바꾸었다.
				
		try {
			//true는 기존 내용에 이어서 쓰는 것, 기존내용을 없애고 새로 쓰려면 false .
			bw = new BufferedWriter(new FileWriter(path,true)); 
			String input = discount +","+CouponName;
			input.trim(); //빈 줄이들어가는 것 방지
			bw.write(input+"/"); //줄바꿈 되어 저장된다.			
			bw.flush();	
			
			System.out.println(input);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer !=null) writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
