/*
 * @author: Ly Ponleu
 */

package object;

import java.util.Scanner;

public abstract class GianHang {
	protected String maGianHang;
    protected double dienTich;
    protected String viTri;
    protected String phanLoai;
    protected boolean isRented;
    protected String tinhTrang;

	//#Phuong thuc get set
    public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
    public boolean isRented() {
		return isRented;
	}
	
	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}
	public String getPhanLoai() {
		return phanLoai;
	}
	public void setPhanLoai(String phanLoai) {
		this.phanLoai = phanLoai;
	}
	
    public String getMaGianHang(){
        return maGianHang;
    }
    public void setMaGianHang(String maGianHang){
        this.maGianHang = maGianHang;
    }

    public double getDienTich(){
        return dienTich;
    }
    public void setDienTich(double dienTich){
        this.dienTich = dienTich;
    }

    public String getViTri(){
        return viTri;
    }
    public void setViTri(String viTri){
        this.viTri = viTri;
    }

    //#Phuong thuc khoi tao
    public GianHang(){
    }
    public GianHang(String maGianHang, double dienTich, String viTri){
        this.maGianHang = maGianHang;
        this.dienTich = dienTich;
        this.viTri = viTri;
    }

    //#Nhap thong tin
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Xin hay nhap ma gian hang: ");
        maGianHang = sc.nextLine();
        System.out.print("Xin hay nhap dien tich cua gian hang: ");
        dienTich = Double.parseDouble(sc.nextLine());
        System.out.print("Xin hay nhap vi tri cua gia hang: ");
        viTri = sc.nextLine();
    }

    //#Chi phi thue (truu tuong)
    public abstract double chiPhiThue(int soNgay);
}
