/*
 * Nguyen Van Tung
 */
package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import object.GianHang;
import object.GianHangCaoCap;
import object.GianHangTieuChuan;

public class DoanhSoController implements Initializable {
	
	@FXML
    private TextArea display;

    @FXML
    private Button back_button;

    @FXML
    private TextField ngay_input;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ngay_input.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Integer date = Integer.parseInt(ngay_input.getText());
				
				Double sum = 0d;
				for (GianHang obj : Controller.bigList) {
					if (obj.isRented()) {
						if (obj.getPhanLoai().equals("tc")) {
							GianHangTieuChuan ghtc = (GianHangTieuChuan) obj;
							sum += ghtc.chiPhiThue(date);
						}
						else if (obj.getPhanLoai().equals("cc")) {
							GianHangCaoCap ghcc = (GianHangCaoCap) obj;
							sum += ghcc.chiPhiThue(date);
						}
					}
				}
				DecimalFormat format = new DecimalFormat("0.#");
				display.setText("Tổng doanh thu trong " + date + " ngày là: " + format.format(sum) + "0000VND.");
				ngay_input.clear();
			}
		});
		
	}
	
	 @FXML
	    void backButtonClicked(ActionEvent event) throws Exception {
		 	Stage stage = (Stage) back_button.getScene().getWindow();
		 	stage.close();
	    }

}
