/*
 * @author: Ly Ponleu
 */

package object;

import java.time.LocalDate;
import java.util.Scanner;

public class KhachHang {
	
	private String ten;
    private String diaChi;
    private LocalDate thoiGianBatDau;
	private LocalDate thoiGianKetThuc;
    private String maGianHangThue;
    private double tienDatCoc;
     
    public KhachHang() {}
     
    public KhachHang(String ten, String diaChi, String thoiGianBatDau, String thoiGianKetThuc,
            String maGianHangThue, double tienDatCoc) {
        this.ten = ten;
        this.diaChi = diaChi;
        this.maGianHangThue = maGianHangThue;
        this.tienDatCoc = tienDatCoc;     
    }
     

    // Getters and Setter
    public LocalDate getThoiGianBatDau() {
		return thoiGianBatDau;
	}

	public void setThoiGianBatDau(LocalDate thoiGianBatDau) {
		this.thoiGianBatDau = thoiGianBatDau;
	}

	public LocalDate getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(LocalDate thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}
    public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaGianHangThue() {
		return maGianHangThue;
	}

	public void setMaGianHangThue(String maGianHangThue) {
		this.maGianHangThue = maGianHangThue;
	}

	public double getTienDatCoc() {
		return tienDatCoc;
	}

	public void setTienDatCoc(double tienDatCoc) {
		this.tienDatCoc = tienDatCoc;
	}

	// Nhap thong tin khach hang 
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap Ten Khach Hang: ");
        ten = scanner.nextLine();
        System.out.print("Nhap Dia Chi: ");
        diaChi = scanner.nextLine();
//        System.out.print("Nhap Thoi Gian Bat Dau Thue: ");
//        thoiGianBatDau = scanner.nextLine();
//        System.out.print("Nhap Thoi Gian Ket Thuc Thue: ");
//        thoiGianKetThuc = scanner.nextLine();
        System.out.print("Nhap Ma Gian Hang Thue: ");
        maGianHangThue = scanner.nextLine();
        System.out.print("Nhap So Tien Dat Coc: ");
        tienDatCoc = Double.parseDouble(scanner.nextLine());
        
        scanner.close();
    }
    
    // Hien thi thong tin khach Hang
    public void inTT() {
        System.out.println("Ten Khach Hang: " + ten);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Thoi Gian Bat Dau Thue: " + thoiGianBatDau);
        System.out.println("Thoi Gian Ket Thuc Thue: " + thoiGianKetThuc);
        System.out.println("Ma Gian Hang Thue: " + maGianHangThue);
        System.out.println("Tien Dat Coc: " + tienDatCoc);
    }
}
