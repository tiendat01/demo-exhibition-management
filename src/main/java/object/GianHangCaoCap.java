/*
 * @author: Tran Minh Dung
 */

package object;

import java.util.Scanner;

public class GianHangCaoCap extends GianHang {

	private int soLuongQuat;
    private int soLuongGhe;
    public static int SO_GIAN_HANG_THUE;

    //#Phuong thuc get set
    public int getSoLuongQuat(){
        return soLuongQuat;
    }
    public void setSoLuongQuat(int soLuongQuat){
        this.soLuongQuat = soLuongQuat;
    }

    public int getSoLuongGhe(){
        return soLuongGhe;
    }
    public void setSoLuongGhe(int soLuongGhe){
        this.soLuongGhe = soLuongGhe;
    }

    public static int getSO_GIAN_HANG_THUE() {
		return SO_GIAN_HANG_THUE;
	}
	public static void setSO_GIAN_HANG_THUE(int sO_GIAN_HANG_THUE) {
		SO_GIAN_HANG_THUE = sO_GIAN_HANG_THUE;
	}
	//#Phuong thuc khoi tao
    public GianHangCaoCap(){
    }
    public GianHangCaoCap(String maGianHang, double dienTich, String viTri, int soLuongQuat, int soLuongGhe){
        super(maGianHang, dienTich, viTri);
        this.soLuongGhe = soLuongGhe;
        this.soLuongQuat = soLuongQuat;
    }

    //#In thong tin
    public void inTT(){
        System.out.println("Ma gian Hang la: " + maGianHang);
        System.out.println("Dien tich gian hang la: " + dienTich);
        System.out.println("Vi tri cua gian Hang la: " + viTri);
        System.out.println("So luong quat cua gian Hang la: " + soLuongQuat);
        System.out.println("So luong ghe cua gian Hang la: " + soLuongGhe);
        System.out.println("Tinh trang: " + (isRented ? "Not Avaiblable" : "Available"));
        System.out.println("So gian hang cao cap da thue la: " +  SO_GIAN_HANG_THUE);
        System.out.println("Chi phi thue moi ngay la : " + chiPhiThue(1)+"0000VND");
    }

    //#Chi phi thue
    @Override
    public double chiPhiThue(int soNgay) {
        return (dienTich * 12 + soLuongQuat * 5) * soNgay;
    }

    public void input(){
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Xin hay nhap so luong quat cua gian hang: ");
        soLuongQuat = Integer.parseInt(sc.nextLine());
        System.out.print("Xin hay nhap so luong ghe cua gian hang: ");
        soLuongGhe = Integer.parseInt(sc.nextLine());
    }
	@Override
	public String toString() {
		return "Gian Hang Cao Cap ["
				+ "\n- Ma gian hang: " + maGianHang
				+ "\n- Dien tich: " + dienTich
				+ "\n- Vi tri: " + viTri
				+ "\n- Trang thai: " + tinhTrang
				+ "\n- So luong quat lam mat: " + soLuongQuat
				+ "\n- So luong ban ghe theo kem: " + soLuongGhe
				+ "\n]";
	}
    
    

}
