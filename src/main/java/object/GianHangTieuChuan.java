/*
 * @author: Nguyen Van Tung
 */

package object;

import java.util.Scanner;
//import java.awt.color.*;

public class GianHangTieuChuan extends GianHang {
	private String chatLieuVachNgan, chatLieuMaiChe;
	public static int SO_GIAN_HANG_THUE;	
	
	// Phuong thuc khoi tao.
	public GianHangTieuChuan() {
	}
	public GianHangTieuChuan(String maGianHang, double dienTich, String viTri, String chatLieuVachNgan, String chatLieuMaiChe) {
		super(maGianHang, dienTich, viTri);
		this.chatLieuVachNgan = chatLieuVachNgan;
		this.chatLieuMaiChe = chatLieuMaiChe;
	}
	
	// Cac phuong thuc get, set.
	public String getChatLieuVachNgan() {
		return chatLieuVachNgan;
	}
	public void setChatLieuVachNgan(String chatLieuVachNgan) {
		this.chatLieuVachNgan = chatLieuVachNgan;
	}
	public String getChatLieuMaiChe() {
		return chatLieuMaiChe;
	}
	public void setChatLieuMaiChe(String chatLieuMaiChe) {
		this.chatLieuMaiChe = chatLieuMaiChe;
	}
	public static int getSO_GIAN_HANG_THUE() {
		return SO_GIAN_HANG_THUE;
	}
	public static void setSO_GIAN_HANG_THUE(int sO_GIAN_HANG_THUE) {
		SO_GIAN_HANG_THUE = sO_GIAN_HANG_THUE;
	}
	
	// Nhap thong tin.
	public void input() {
		Scanner sc = new Scanner (System.in);
		super.input();
		System.out.print("Xin hay nhap chat lieu vach ngan: ");
		chatLieuVachNgan = sc.nextLine();
		System.out.print("Xin hay nhap chat lieu mai che: ");
		chatLieuMaiChe = sc.nextLine();
	}
	
	// In thong tin.
	public void inTT() {
		System.out.println("Ma gian Hang la: " + maGianHang);
		System.out.println("Dien tich gian hang la: " + dienTich);
		System.out.println("Vi tri cua gian Hang la: " + viTri);
		System.out.println("Chat lieu vach ngan cua gian Hang la: " + chatLieuVachNgan);
		System.out.println("Chat lieu mai che cua gian Hang la: " + chatLieuMaiChe);
		System.out.println("Tinh trang: " + (isRented ? "Not Available" : "Available"));
		System.out.println("So gian hang tieu chuan da thue la: " +  SO_GIAN_HANG_THUE);
		System.out.println("Chi phi thue moi ngay la : " + (chiPhiThue(1)) + "0000VN�");
	}
	
	// Tinh chi phi thue(Lam ro phuong thuc abstract).
	public double chiPhiThue(int soNgay) {
		return (10 * dienTich * soNgay);
	}
	
	public static final String ANSI_RED = "\u001B[31m";
	@Override
	public String toString() {
		return "Gian Hang Tieu Chuan ["
				+ "\n- Ma gian hang: " + maGianHang
				+ "\n- Dien tich: " + dienTich
				+ "\n- Vi tri: " + viTri
				+ "\n- Trang thai: "+ tinhTrang
				+ "\n- Chat lieu vach ngan: " + chatLieuVachNgan
				+ "\n- Chat lieu mai che: " + chatLieuMaiChe 			
				+ "\n]";
	}
	
	
}
