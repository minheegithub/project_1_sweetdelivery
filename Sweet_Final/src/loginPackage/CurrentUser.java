package loginPackage;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CurrentUser {
	String[] bea;
	//by최민희 사용자 정보 가져오기
	public String[] bringUser() {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(".\\src\\resource\\MemberJoin\\currentUser.txt");
			
			br = new BufferedReader(fr);
		
			String readMember = br.readLine();
			bea = readMember.split(",");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bea;
	}
	//by최민희 장바구니에 저장된 상품목록 가져오기
	public String[] bringProduct(String id) {
		File file2 = new File(".\\src\\resource\\Text\\"+id+"Product.txt"); 
		if(!file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		BufferedReader br2 = null;
		try {
			br2 = new BufferedReader(new FileReader(file2));
			
			String line = null;
			if((line = br2.readLine()) != null){
				bea = line.split(",");
			}else {
				//장바구니에 값이 비어있을 경우 에러방지하기 위해 값을 넣어둔다.
				line =",";
				bea = line.split(",");
				System.out.println("저장된상품이 없다.");
			}
			
			for (int i = 0; i < bea.length; i++) {
				System.out.println("상품:"+bea[i]);
			}
		
		} catch (IOException e1) {				
			e1.printStackTrace();
		}
		
		return bea;
	}
	//by최민희 장바구니에 저장된 상품 가격 가져오기
	public String[] bringCost(String id) {
		File file = new File(".\\src\\resource\\Text\\"+id+"Cost.txt"); 
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		BufferedReader br2 = null;
		try {
			br2 = new BufferedReader(new FileReader(file));
			String line = null;
			if((line = br2.readLine()) != null){
				bea = line.split(",");
			}else {
				//장바구니에 값이 비어있을 경우 에러방지하기 위해 값을 넣어둔다.
				line =",";
				bea = line.split(",");
				System.out.println("저장된상품가격이 없다.");
			}
			
			for (int i = 0; i < bea.length; i++) {
				System.out.println("상품가격:"+bea[i]);
			}
			
			
		} catch (IOException e1) {				
			e1.printStackTrace();
		}
		
		return bea;
	}
	//by최민희 장바구니에 저장된 총 금액 가져오기
	public String bringTotal(String id) {
		File file3 = new File(".\\src\\resource\\Text\\"+id+"Total.txt"); //장바구니에 담긴 총 금액이 저장된다.
		//by최민희 파일 없을 경우 오류방지하기 위해 파일 생성
		if(!file3.exists()) {
			try {
				file3.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		BufferedReader bw3 = null;
		String line3 = null;
		try {
			bw3 = new BufferedReader(new FileReader(file3));
			line3 = bw3.readLine();
		} catch (IOException e2) {			
			e2.printStackTrace();
		}
		return line3;
	}
}
