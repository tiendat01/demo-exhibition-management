/*
 * @author: Tran Minh Dung
 */

package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import object.GianHang;
import object.GianHangCaoCap;
import object.GianHangTieuChuan;

public class GianHangCaoCapController implements Initializable {

    @FXML
    private TableView<GianHang> table;
    
    @FXML
    private TableColumn<GianHang, String> viTricol;

    @FXML
    private TableColumn<GianHang, String> maGianHangcol;

    @FXML
    private TableColumn<GianHang, Double> dienTichcol;

    @FXML
    private TableColumn<GianHang, Integer> soLuongBanGhecol;
    
    @FXML
    private TableColumn<GianHang, Integer> soLuongQuatcol;
    
    @FXML
	private TableColumn <GianHang, String> tinhTrangcol;

    @FXML
    private TextField banghe_input;

    @FXML
    private TextField quat_input;

    @FXML
    private TextField dt_input;

    @FXML
    private TextField vt_input;

    @FXML
    private TextField maGH_input;
   
    @FXML
    private Button delete_button;

    @FXML
    private Button add_button;
    
    
    
    // public ObservableList<GianHang> list = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	maGianHangcol.setCellValueFactory(new PropertyValueFactory<GianHang, String>("maGianHang"));
		viTricol.setCellValueFactory(new PropertyValueFactory<GianHang, String>("viTri"));
		dienTichcol.setCellValueFactory(new PropertyValueFactory<GianHang, Double>("dienTich"));
		soLuongQuatcol.setCellValueFactory(new PropertyValueFactory<GianHang, Integer>("soLuongQuat"));
		soLuongBanGhecol.setCellValueFactory(new PropertyValueFactory<GianHang, Integer>("soLuongGhe"));
		tinhTrangcol.setCellValueFactory(new PropertyValueFactory<GianHang, String>("tinhTrang"));
		
		// list = Controller.bigList;
		// table.setItems(list);
		for (GianHang obj : Controller.bigList) {
			if (obj.getPhanLoai().equals("cc")) {				
				if (obj.isRented()) obj.setTinhTrang("Not Available");
				else obj.setTinhTrang("Available");
				table.getItems().add(obj);
			}
		}
		
		table.setEditable(true);
		
//		ko cho phep sua ma gian hang => dam bao tinh an toan du lieu
//		maGianHangcol.setCellFactory(TextFieldTableCell.forTableColumn());
//		maGianHangcol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GianHang, String>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<GianHang, String> gianHangStringCellEditEvent) {
//                GianHang gianHang = gianHangStringCellEditEvent.getRowValue();
//                gianHang.setMaGianHang(gianHangStringCellEditEvent.getNewValue());
//            }
//        });
		viTricol.setCellFactory(TextFieldTableCell.forTableColumn());
		viTricol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GianHang, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GianHang, String> gianHangStringCellEditEvent) {
                GianHang gianHang = gianHangStringCellEditEvent.getRowValue();
                gianHang.setViTri(gianHangStringCellEditEvent.getNewValue());
            }
        });
		dienTichcol.setCellFactory(TextFieldTableCell.<GianHang, Double>forTableColumn(new DoubleStringConverter()));
		dienTichcol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GianHang, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GianHang, Double> gianHangStringCellEditEvent) {
                GianHang gianHang = gianHangStringCellEditEvent.getRowValue();
                gianHang.setDienTich(gianHangStringCellEditEvent.getNewValue());
            }
        });
		soLuongQuatcol.setCellFactory(TextFieldTableCell.<GianHang, Integer>forTableColumn(new IntegerStringConverter()));
		soLuongQuatcol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GianHang, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GianHang, Integer> gianHangStringCellEditEvent) {
                GianHang gianHang = new GianHangCaoCap();
                gianHang = gianHangStringCellEditEvent.getRowValue();
                GianHangCaoCap ghcc = (GianHangCaoCap) gianHang;
                ghcc.setSoLuongQuat(gianHangStringCellEditEvent.getNewValue());
            }
        });
		soLuongBanGhecol.setCellFactory(TextFieldTableCell.<GianHang, Integer>forTableColumn(new IntegerStringConverter()));
		soLuongBanGhecol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GianHang, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GianHang, Integer> gianHangStringCellEditEvent) {
                GianHang gianHang = new GianHangCaoCap();
                gianHang = gianHangStringCellEditEvent.getRowValue();
                GianHangCaoCap ghcc = (GianHangCaoCap) gianHang;
                ghcc.setSoLuongGhe(gianHangStringCellEditEvent.getNewValue());
            }
        });
		
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    void showAlert_notDelete() {
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("ERROR ALERT");
    	alert.setHeaderText("Error!!!");
    	alert.setContentText("Không thể xóa gian hàng này vì nó đang được cho thuê.");
    	alert.showAndWait();
    }
    
 // cho nay hoi loi
 	String input;
 	
 	void showAlertF() {
 		Alert alert = new Alert(AlertType.ERROR);
 		alert.setTitle("ERROR ALERT");
 		alert.setHeaderText("Error!!!");
 		alert.setContentText("Mã gian hàng \"" + input + "\" đã tồn tại! " + "\nVui lòng nhập lại mã gian hàng!!!");
 		alert.showAndWait();
 	}
 	
 	void showAlertT() {
 		Alert alert = new Alert(AlertType.CONFIRMATION);
 		alert.setTitle("CONFIRMATION ALERT");
 		alert.setHeaderText("Confirmation");
 		alert.setContentText("Đã thêm gian hàng mã \"" + input + "\".");
 		alert.showAndWait();
 	}

    @FXML
    void addButtonClicked(ActionEvent event) throws Exception {
    	GianHang ghcc = new GianHangCaoCap();
    	GianHangCaoCap ghcc_down = (GianHangCaoCap) ghcc; 
    	
		
		ghcc_down.setViTri(vt_input.getText());
		ghcc_down.setDienTich(Double.parseDouble(dt_input.getText()));
		ghcc_down.setSoLuongQuat(Integer.parseInt(quat_input.getText()));
		ghcc_down.setSoLuongGhe(Integer.parseInt(banghe_input.getText()));
		ghcc_down.setPhanLoai("cc");
		if (ghcc_down.isRented()) ghcc_down.setTinhTrang("Not Available");
		else ghcc_down.setTinhTrang("Available");
		
		ghcc_down.setMaGianHang(maGH_input.getText());
		input = ghcc_down.getMaGianHang();
		
		boolean flag = false;		
		int count = 0;
		for (GianHang obj : Controller.bigList) {
	    	if (obj.getMaGianHang().equals(ghcc_down.getMaGianHang())) {			
	    		showAlertF();
	        	maGH_input.clear();
	        	break;
	    	}
	    	count++;
	    }
		if (count == Controller.bigList.size()) flag = true;
		
		if (flag) {
			table.getItems().add(ghcc);
			Controller.bigList.add(ghcc);
			
			showAlertT();
			maGH_input.clear();
			vt_input.clear();
			dt_input.clear();
			quat_input.clear();
			banghe_input.clear();
		}
		
}

    @FXML
    void deleteButtonClicked(ActionEvent event) throws Exception {
    	GianHang ghSelected = table.getSelectionModel().getSelectedItem();
    	if (!ghSelected.isRented()) {
    		table.getItems().remove(ghSelected);
        	Controller.bigList.remove(ghSelected);
    	}
    	else showAlert_notDelete();
//    	GianHangCaoCap.SO_GIAN_HANG_THUE--;
    }

}
