/*
 * @author: Nguyen Tien Dat
 */

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import object.GianHangCaoCap;
import object.GianHangTieuChuan;

public class ThongKeController implements Initializable {
	
	@FXML
    private PieChart pieChart;
	
	@FXML 
	private Label soLuong;
	
	@FXML
	private Button back_button;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<PieChart.Data> pieChartData =
	            FXCollections.observableArrayList(
	            new PieChart.Data("Gian Hàng Tiêu Chuẩn", GianHangTieuChuan.SO_GIAN_HANG_THUE),
	            new PieChart.Data("Gian Hàng Cao Cấp", GianHangCaoCap.SO_GIAN_HANG_THUE));
		pieChart.setData(pieChartData);
		
		soLuong.setTextFill(Color.BLACK);
		soLuong.setStyle("-fx-font: 30 arial;");
		
		for (final PieChart.Data data : pieChart.getData()) {
		    data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
		        new EventHandler<MouseEvent>() {
		            @Override 
		            public void handle(MouseEvent e) {
		                soLuong.setTranslateX(e.getSceneX() - soLuong.getLayoutX());
		                soLuong.setTranslateY(e.getSceneY() - soLuong.getLayoutY());
		                soLuong.setText(String.valueOf((int)data.getPieValue()));
		                System.out.println("pie chart click");
		             }
		        });
		}
	}
	
	@FXML
	void backButtonClicked(ActionEvent event) throws Exception {
		Stage stage = (Stage) back_button.getScene().getWindow();
		stage.close();
    }
}
