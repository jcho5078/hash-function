package hash;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static String salt = SHA256.generateSalt();// 메서드에 사용할 매개변수인 난수 생성.
	
	public static void main(String[] args) throws Exception{
		String temp;// 입력용 변수.
		String data;// 변수 data를 암호화(서버 저장용).
		
		System.out.print("SHA256-데이터 입력: ");
		temp = scan.nextLine();
		data = SHA256.getEncrypt(temp, salt);// 암호화 메서드 사용.
		System.out.println("SHA256-암호화 완성: "+ data);
		
		System.out.print("AES256-데이터 입력: ");
		temp = scan.nextLine();
		data = AES256.encryptAES256(temp, salt);
		System.out.println("AES256-암호화 완성: "+ data);//암호화.
		
		temp = AES256.decryptAES256(data, salt);
		System.out.println("AES256-복호화 완성: "+ temp);//복호화.
	}
}
