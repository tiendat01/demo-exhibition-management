/*
 * @author: Nguyen Tien Dat
 */

package application;

import java.io.IOException;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import object.GianHang;
import object.GianHangCaoCap;
import object.GianHangTieuChuan;
import object.KhachHang;

public class Controller implements Initializable {
	
	   public static ObservableList<GianHang> bigList = FXCollections.observableArrayList();
	   public static ObservableList<KhachHang> bigKH = FXCollections.observableArrayList();
	 
	   @FXML
	   private Button button_ghtc;
	   @FXML
	   private Button button_ghcc;
	   @FXML
	   private Button button_khach;
	   @FXML
	   private Button button_search;
	   @FXML
	   private Button button_tk;
	   @FXML
	   private Button button_ds;
	  
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
		   // doc du lieu tu file vao cac arraylist
		   InputStream inputStream = null;
		   InputStreamReader inputStreamReader = null;
		   BufferedReader bufferedReader = null;
		   try {
			   File file = new File("GHdata.txt");
			   inputStream = new FileInputStream(file);
			   inputStreamReader = new InputStreamReader(inputStream);
			   bufferedReader = new BufferedReader(inputStreamReader);
			   
			   String line = "";
			   while ((line = bufferedReader.readLine()) != null) {
				   if (line.equals("tc")) {
					   GianHang obj = new GianHangTieuChuan();
					   GianHangTieuChuan ghtc = (GianHangTieuChuan) obj;
					   ghtc.setPhanLoai(line);
					   ghtc.setMaGianHang(bufferedReader.readLine());
					   ghtc.setViTri(bufferedReader.readLine());
					   ghtc.setDienTich(Double.parseDouble(bufferedReader.readLine()));
					   ghtc.setChatLieuVachNgan(bufferedReader.readLine());
					   ghtc.setChatLieuMaiChe(bufferedReader.readLine());
					   ghtc.setTinhTrang(bufferedReader.readLine());
					   bufferedReader.readLine();
					   bigList.add(obj);
				   }
				   else if (line.equals("cc")) {
					   GianHang obj = new GianHangCaoCap();
					   GianHangCaoCap ghcc = (GianHangCaoCap) obj;
					   ghcc.setPhanLoai(line);
					   ghcc.setMaGianHang(bufferedReader.readLine());
					   ghcc.setViTri(bufferedReader.readLine());
					   ghcc.setDienTich(Double.parseDouble(bufferedReader.readLine()));
					   ghcc.setSoLuongQuat(Integer.parseInt(bufferedReader.readLine()));
					   ghcc.setSoLuongGhe(Integer.parseInt(bufferedReader.readLine()));
					   ghcc.setTinhTrang(bufferedReader.readLine());
					   bufferedReader.readLine();
					   bigList.add(obj);
				   }
				   
			   }			   
//			   for (GianHang obj : bigList) {
//				   System.out.println(obj);
//			   }
		   } catch (Exception e){
			   System.out.println("Cannot read file!");
		   } finally {
			   try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
	      
		   
		   
		   
		   // doc tu KHdata.txt to bigKH list
		   try {
			   File file = new File("KHdata.txt");
			   inputStream = new FileInputStream(file);
			   inputStreamReader = new InputStreamReader(inputStream);
			   bufferedReader = new BufferedReader(inputStreamReader);
			   
			   String line = "";
			   while ((line = bufferedReader.readLine()) != null) {
				   KhachHang kh = new KhachHang();
				   // set trang thai cho ma gian hang duoc thue:
				   kh.setMaGianHangThue(line);
				   for (GianHang obj : bigList) {
					   if (obj.getMaGianHang().equals(line)) {
						   obj.setRented(true);
						   if (obj.getPhanLoai().equals("tc")) GianHangTieuChuan.SO_GIAN_HANG_THUE++;
						   else if (obj.getPhanLoai().equals("cc")) GianHangCaoCap.SO_GIAN_HANG_THUE++;
						   break;
					   }
				   }
				   kh.setTen(bufferedReader.readLine());
				   kh.setDiaChi(bufferedReader.readLine());
				   kh.setTienDatCoc(Double.parseDouble(bufferedReader.readLine()));
				   String start = bufferedReader.readLine();
				   kh.setThoiGianBatDau(LocalDate.parse(start, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
				   kh.setThoiGianKetThuc(LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy")));
				   bufferedReader.readLine();
				   bigKH.add(kh);
			   }			   
//			   for (KhachHang obj : bigKH) {
//				   System.out.println(obj);
//			   }
		   } catch (Exception e){
			   System.out.println("Cannot read file!????");
		   } finally {
			   try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				inputStreamReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   
	   }
	   
	   
	   
	   public void gianHangTieuChuan(ActionEvent event) throws Exception {
		   Parent root1 = FXMLLoader.load(getClass().getResource("GianHangTieuChuan.fxml"));
		   Scene scene = new Scene(root1,1050,600);
		   
//		   Stage ghtc = (Stage) button1.getScene().getWindow(); // chuyen doi giua 2 scene
		   Stage ghtc = new Stage(); // tao stage moi
		   ghtc.initModality(Modality.APPLICATION_MODAL);
		   ghtc.setTitle("QUAN LÝ GIAN HÀNG TIÊU CHUẨN");
		   ghtc.setScene(scene);
		   ghtc.show();
		   
		   System.out.println("GIAN HANG TIEU CHUAN FROM BIGlist:");
		   for (GianHang obj : bigList) {
			   if (obj.getPhanLoai().equals("tc")) {
				   GianHangTieuChuan obj_down = (GianHangTieuChuan) obj;
				   obj_down.inTT();
				   System.out.println();
			   }
		   }
	   }
	   
	   public void gianHangCaoCap(ActionEvent event) throws Exception {
		   Parent root1 = FXMLLoader.load(getClass().getResource("GianHangCaoCap.fxml"));
		   Scene scene = new Scene(root1,1050,600);
		   
		   Stage ghcc = new Stage(); // tao stage moi
		   ghcc.initModality(Modality.APPLICATION_MODAL);
		   ghcc.setTitle("QUẢN LÝ GIAN HÀNG CAO CẤP");
		   ghcc.setScene(scene);
		   ghcc.show();
		   
		   System.out.println("GIAN HANG CAO CAP FROM BIGlist:");
		   for (GianHang obj : bigList) {
			   if (obj.getPhanLoai().equals("cc")) {
				   GianHangCaoCap obj_down = (GianHangCaoCap) obj;
				   obj_down.inTT();
				   System.out.println();
			   }		   
		   }
	   }
	   
	   public void KhachHang(ActionEvent event) throws Exception {
		   Parent root1 = FXMLLoader.load(getClass().getResource("KhachHang.fxml"));
		   Scene scene = new Scene(root1,1050,675);

		   Stage ghcc = new Stage(); // tao stage moi
		   ghcc.initModality(Modality.APPLICATION_MODAL);
		   ghcc.setTitle("QUẢN LÝ KHÁCH HÀNG CHO THUÊ");
		   ghcc.setScene(scene);
		   ghcc.show();
	   }
	   
	   public void Search(ActionEvent event) throws Exception {
		   Parent root1 = FXMLLoader.load(getClass().getResource("SearchID.fxml"));
		   Scene scene = new Scene(root1);
		   Stage search = new Stage(); // tao stage moi
		   search.initModality(Modality.APPLICATION_MODAL);
		   search.setTitle("TÌM KIẾM");
		   search.setScene(scene);
		   search.show();
	   }
	   
	   public void ThongKe(ActionEvent event) throws Exception {
		   Parent root1 = FXMLLoader.load(getClass().getResource("ThongKe.fxml"));
		   Scene scene = new Scene(root1, 650, 400);
		   Stage search = new Stage(); // tao stage moi
		   search.initModality(Modality.APPLICATION_MODAL);
		   search.setTitle("THỐNG KÊ");
		   search.setScene(scene);
		   search.show();
	   }
	   
	   public void DoanhSo(ActionEvent event) throws Exception {
		   Parent root1 = FXMLLoader.load(getClass().getResource("DoanhSo.fxml"));
		   Scene scene = new Scene(root1, 650, 400);
		   Stage search = new Stage(); // tao stage moi
		   search.initModality(Modality.APPLICATION_MODAL);
		   search.setTitle("TÍNH DOANH SỐ");
		   search.setScene(scene);
		   search.show();
	   }
	   
	   

}