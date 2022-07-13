package payPackage;
//장바구니 총합을 계산하고 쓰기 위한 클래스. SweetDelivery 클래스와 연동된다.
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Total {
//	private int point; //포인트 
//
//	
//	public int getPoint() {
//		return point;
//	}
//	public void setPoint(int point) {
//		this.point = point;
//	}
//	
//	public Total() {
//		
//	}
//	//생성자 오버로딩
//	public Total(int point) {
//		this.point = point;
//	}

	
	//메서드 오버로딩- 포인트---------------------------------------------------------------------------------------//
	public void WriteToFile(int point,String id) {
	 String path =".\\src\\resource\\Text\\"+id+"Total.txt";
	//읽기- 읽어서 기존 값에 받아온 값을 더해야 한다.
//	 File file = new File(path);
	 int sum=0;
	 int plus;
	 
	 try {
		 File f = new File(path);
		 if(!f.exists()) {
			 f.createNewFile();
		 };
		 	DataInputStream dis = new DataInputStream(new FileInputStream(path));
		 		String text = dis.readLine();
		 		//저장된 총금액이 없을경우 에러를 방지하기 위해 0을 임의로 넣음
		 		if(text == null) {
		 			text = "0";
		 		}
		 	System.out.println("토탈에서 읽어온 값"+text);

			plus = Integer.parseInt(text); //문자열을 정수로 바꿈.
			sum = plus + point; //기존 값과 합쳤음.
		}catch (Exception e) {
			e.printStackTrace();
		}		
		
	//쓰기
	FileWriter writer = null;
	String message = String.valueOf(sum); //새롭게 계산한 값을 파일에 쓰기 위해 문자열로 바꾸었다.
	try {
		//true는 기존 내용에 이어서 쓰는 것, 기존내용을 없애고 새로 쓰려면 false .-> 매번 값을 받을 때마다 갱신된다.
		writer = new FileWriter(path,false); 
		System.out.println("장바구니로 총 "+message+"원 저장");
		writer.write(message);
		writer.flush();
		

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