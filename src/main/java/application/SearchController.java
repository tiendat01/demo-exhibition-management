/*
 * @author: Nguyen Tien Dat
 */

package application;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ResourceBundle;

import object.GianHang;
import object.GianHangCaoCap;
import object.GianHangTieuChuan;
import javafx.fxml.Initializable;

public class SearchController implements Initializable {
	
	@FXML
    private Button search_button;

    @FXML
    private TextField maGH_input;

    @FXML
    private TextArea info;

    @FXML
    private Button back_button;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
//		Image img = new Image("application/searchImage.png");
//		ImageView view = new ImageView(img);
//		view.setFitHeight(20);
//		view.setPreserveRatio(true);
		search_button.setPrefSize(31, 31);
//		search_button.setGraphic(view);
		info.setText("No content to display");
	}

	@FXML
    void searchButtonClicked(ActionEvent event) throws Exception {
    	GianHang res = Controller.bigList.stream().filter(gh -> gh.getMaGianHang().equals(maGH_input.getText())).findFirst().orElse(null);
    	if (res == null) {
    		info.setText("Khong co ma gian hang nay!");
    		maGH_input.clear();
    		return;
    	}

    	if (res.getPhanLoai().equals("tc")) {
    		GianHangTieuChuan ghtc = (GianHangTieuChuan) res;
    		info.setText(ghtc.toString());
    	}
    	else if (res.getPhanLoai().equals("cc")) {
    		GianHangCaoCap ghcc = (GianHangCaoCap) res;
    		info.setText(ghcc.toString());
    	}
    }
	
	@FXML
    void backButtonClicked(ActionEvent event) throws Exception {
		Stage stage = (Stage) back_button.getScene().getWindow();
		stage.close();
    }
}
