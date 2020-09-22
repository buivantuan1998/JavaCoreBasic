package com.xtel.javacorebase;

import java.util.Scanner;

/**
 * @author TUAN
 *
 */
public class Bai1 {
	
	public void kiemTraSoCanNhap(){
		int i;
		int soCanNhap;
		int soBanDau = 10;
		try(Scanner sc = new Scanner(System.in)) {
			for(i=0; i< 5; i++ ) {
				System.out.print("Nhap vao so can nhap: ");
				soCanNhap=sc.nextInt();
				if(soCanNhap == soBanDau) {
					System.out.println("Thanh cong.");
					break;
				}
			}
			//System.out.println("Nhap loi");
		} catch (Exception e) {
			System.out.println("Loi");
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Bai1 b = new Bai1();
		b.kiemTraSoCanNhap();
	}

}
