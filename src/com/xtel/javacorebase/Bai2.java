/**
 * 
 */
package com.xtel.javacorebase;

import java.util.Scanner;

/**
 * @author TUAN
 *
 */
public class Bai2 {

	public void tinhTienDien() {
		int tongTienDien=0;
		int soDien;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao so dien cua ban: ");
		soDien=sc.nextInt();
		if(soDien<100) {
			tongTienDien=soDien*1000;
		}
		if(soDien>=100 && soDien<150) {
			soDien=soDien-99;
			tongTienDien=99*1000+soDien*1500;
		}
		if(soDien>=150) {
			soDien=soDien-149;
			tongTienDien=99*1000+50*1500+soDien*2000;
		}
		System.out.println("Tong tien dien cua ban la: "+tongTienDien);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bai2 b= new Bai2();
		b.tinhTienDien();
	}

}