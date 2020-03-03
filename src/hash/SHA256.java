package hash;

import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SHA256 {
	// 암호화 할 때 짝을 이루는 난수 발생시켜 암호화에 이용. 이 난수는 Salt라 함.
	// DB에는 함호화된 비밀번호와 Salt값 저장.
	// 로그인에 접목시에는 입력한 pwd와 salt를 통해 암호화 시킨값을 비밀번호로 하여 쿼리문 수행.
	
	public static String getEncrypt(String source, String salt) {// 메서드 오버로딩
		return getEncrypt(source, salt.getBytes());
	}
	
	/*
	 * SHA-256 암호화 함.
	 */
	public static String getEncrypt(String source, byte[] salt) {
		String result = null;
		
		byte[] a = source.getBytes();// 
		byte[] bytes = new byte[a.length + salt.length];
		
		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		try {
			// 암호화 방식 지정 메소드 MessageDigest객체에서 사용.
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			
			byte[] byteData = md.digest();
			
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}
			
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/*
	 * Salt 얻어오는 함수.
	 */
	public static String generateSalt() { 
		Random random = new Random();
		
		byte[] salt = new byte[8];
		random.nextBytes(salt);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < salt.length; i++) {
			// byte 값을 Hex 값으로 바꾸기.
			sb.append(String.format("%02x",salt[i]));
		}
		
		return sb.toString();
	}
}
