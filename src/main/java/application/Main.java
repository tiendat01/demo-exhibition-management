/*
 * @author: Nguyen Tien Dat
 */

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import object.GianHang;
import object.GianHangCaoCap;
import object.GianHangTieuChuan;
import object.KhachHang;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.*;
import java.net.URL;
import java.time.format.DateTimeFormatter;

public class Main extends Application {
	Stage window;
	@Override
	public void start(Stage primaryStage) {

		URL url = getClass().getResource("MainApplication.fxml");
		System.out.println("Oke");
		System.out.println(url.toString());

		try {
			window = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("MainApplication.fxml"));
			primaryStage.setTitle("MY APPLICATION");
			
			primaryStage.setOnCloseRequest(e -> closeSaved());
			
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ghi du lieu ra file
	public void closeSaved() {
		Boolean answer = ConfirmBox.display("COMFIRM", "   BẠN CÓ MUỐN LƯU DỮ LIỆU TRƯỚC KHI THOÁT??    \n\n");
		if (answer) {
			// save data for GHlist
			try {
				// dung outputstream writer de ghi du lieu ra file
				File file = new File("GHdata.txt");
				OutputStream outputStream = new FileOutputStream(file);
		        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		        
		        for (GianHang obj : Controller.bigList){
		        	if (obj.getPhanLoai().equals("tc")) {
		        		GianHangTieuChuan ghtc = (GianHangTieuChuan) obj;
		        		outputStreamWriter.write(ghtc.getPhanLoai()); 		outputStreamWriter.write("\n");
		        		outputStreamWriter.write(ghtc.getMaGianHang());		outputStreamWriter.write("\n");
		        		outputStreamWriter.write(ghtc.getViTri());			outputStreamWriter.write("\n");
		        		
		        		Double tmp = ghtc.getDienTich();
		        		outputStreamWriter.write(tmp.toString());			outputStreamWriter.write("\n");
		        		outputStreamWriter.write(ghtc.getChatLieuVachNgan());outputStreamWriter.write("\n");
		        		outputStreamWriter.write(ghtc.getChatLieuMaiChe());	outputStreamWriter.write("\n");
		        		outputStreamWriter.write(ghtc.getTinhTrang());		outputStreamWriter.write("\n");	
		        		outputStreamWriter.write("\n");
		        	}
		        	else if (obj.getPhanLoai().equals("cc")) {
		        		GianHangCaoCap ghcc = (GianHangCaoCap) obj;
		        		outputStreamWriter.write(ghcc.getPhanLoai()); 		outputStreamWriter.write("\n");
		        		outputStreamWriter.write(ghcc.getMaGianHang());		outputStreamWriter.write("\n");
		        		outputStreamWriter.write(ghcc.getViTri());			outputStreamWriter.write("\n");
		        		
		        		Double tmp = ghcc.getDienTich();
		        		outputStreamWriter.write(tmp.toString());			outputStreamWriter.write("\n");
		        		
		        		Integer tmp1 = ghcc.getSoLuongQuat();
		        		outputStreamWriter.write(tmp1.toString());			outputStreamWriter.write("\n");
		        		
		        		Integer tmp2 = ghcc.getSoLuongGhe();
		        		outputStreamWriter.write(tmp2.toString());			outputStreamWriter.write("\n");
		        		outputStreamWriter.write(ghcc.getTinhTrang());		outputStreamWriter.write("\n");	
		        		outputStreamWriter.write("\n");
		        	}
		        }
		        // bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
		        outputStreamWriter.flush();
		        
		        outputStream.close();
		        outputStreamWriter.close();
			} catch (Exception e) {
				System.out.print("Error: Cannot save!");
			}
			
			
			
			// save data for KHlist
			try {
				// dung outputstream writer de ghi du lieu ra file
				File file = new File("KHdata.txt");
				OutputStream outputStream = new FileOutputStream(file);
		        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		        
		        for (KhachHang obj : Controller.bigKH){
		        	outputStreamWriter.write(obj.getMaGianHangThue());	outputStreamWriter.write("\n");
		        	outputStreamWriter.write(obj.getTen());				outputStreamWriter.write("\n");
		        	outputStreamWriter.write(obj.getDiaChi());			outputStreamWriter.write("\n");	
		        	
		        	Double tmp = obj.getTienDatCoc();
		        	outputStreamWriter.write(tmp.toString());			outputStreamWriter.write("\n");
		        	
		        	String tmp1 = obj.getThoiGianBatDau().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		        	outputStreamWriter.write(tmp1);						outputStreamWriter.write("\n");
		        	
		        	String tmp2 = obj.getThoiGianKetThuc().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		        	outputStreamWriter.write(tmp2);						outputStreamWriter.write("\n");
		        	outputStreamWriter.write("\n");
		        }
		        // bắt chương trình chờ ghi dữ liệu xong thì mới kết thúc chương trình.
		        outputStreamWriter.flush();
		        
		        outputStream.close();
		        outputStreamWriter.close();
			} catch (Exception e) {
				System.out.print("Error: Cannot save!");
			}
			
			System.out.print("Saved");
			
			window.close();
		}
		
		else window.close();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
