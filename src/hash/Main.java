package hash;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);
	static String salt = SHA256.generateSalt();// �޼��忡 ����� �Ű������� ���� ����.
	
	public static void main(String[] args) throws Exception{
		String temp;// �Է¿� ����.
		String data;// ���� data�� ��ȣȭ(���� �����).
		
		System.out.print("SHA256-������ �Է�: ");
		temp = scan.nextLine();
		data = SHA256.getEncrypt(temp, salt);// ��ȣȭ �޼��� ���.
		System.out.println("SHA256-��ȣȭ �ϼ�: "+ data);
		
		System.out.print("AES256-������ �Է�: ");
		temp = scan.nextLine();
		data = AES256.encryptAES256(temp, salt);
		System.out.println("AES256-��ȣȭ �ϼ�: "+ data);//��ȣȭ.
		
		temp = AES256.decryptAES256(data, salt);
		System.out.println("AES256-��ȣȭ �ϼ�: "+ temp);//��ȣȭ.
	}
}
