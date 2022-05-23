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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import object.GianHang;
import object.GianHangTieuChuan;

public class GianHangTieuChuanController implements Initializable {
	@FXML
	private TableView<GianHang> table;
	@FXML
	private TableColumn<GianHang, String> maGianHangcol;
	@FXML
	private TableColumn <GianHang, String> viTricol;
	@FXML
	private TableColumn <GianHang, Double> dienTichcol;
	@FXML
	private TableColumn <GianHang, String> chatLieuVachNgancol;
	@FXML
	private TableColumn <GianHang, String> chatLieuMaiChecol;
	@FXML
	private TableColumn <GianHang, String> tinhTrangcol;
	
	 @FXML
	    private TextField vach_input;
	 @FXML
	    private TextField vt_input;
	 @FXML
	    private TextField dt_input;
	 @FXML
	    private TextField mai_input;
	 @FXML
	    private TextField maGH_input;
	 
	 @FXML
	    private Button add_button;
	 @FXML
	    private Button delete_button;
	
//	public ObservableList<GianHang> list = FXCollections.observableArrayList(
//		// new GianHangTieuChuan("ghtc1",1,"asdf","betong","nhua")
//			);
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		maGianHangcol.setCellValueFactory(new PropertyValueFactory<GianHang,String>("maGianHang"));
		viTricol.setCellValueFactory(new PropertyValueFactory<GianHang,String>("viTri"));
		dienTichcol.setCellValueFactory(new PropertyValueFactory<GianHang,Double>("dienTich"));
		chatLieuVachNgancol.setCellValueFactory(new PropertyValueFactory<GianHang,String>("chatLieuVachNgan"));
		chatLieuMaiChecol.setCellValueFactory(new PropertyValueFactory<GianHang,String>("chatLieuMaiChe"));
		tinhTrangcol.setCellValueFactory(new PropertyValueFactory<GianHang, String>("tinhTrang"));
		
		// list = Controller.bigList;
		// table.setItems(list);
		for (GianHang obj : Controller.bigList) {
			if (obj.getPhanLoai().equals("tc")) {
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
		dienTichcol.setCellFactory(TextFieldTableCell.<GianHang,Double>forTableColumn(new DoubleStringConverter()));
		dienTichcol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GianHang, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GianHang, Double> gianHangStringCellEditEvent) {
                GianHang gianHang = gianHangStringCellEditEvent.getRowValue();
                gianHang.setDienTich(gianHangStringCellEditEvent.getNewValue());
            }
        });
		chatLieuVachNgancol.setCellFactory(TextFieldTableCell.forTableColumn());
		chatLieuVachNgancol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GianHang, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GianHang, String> gianHangStringCellEditEvent) {
                GianHang gianHang = new GianHangTieuChuan();
                gianHang =	gianHangStringCellEditEvent.getRowValue();
                GianHangTieuChuan ghtc = (GianHangTieuChuan) gianHang;
                ghtc.setChatLieuVachNgan(gianHangStringCellEditEvent.getNewValue());
            }
        });
		chatLieuMaiChecol.setCellFactory(TextFieldTableCell.forTableColumn());
		chatLieuMaiChecol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GianHang, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GianHang, String> gianHangStringCellEditEvent) {
                GianHang gianHang = new GianHangTieuChuan();
                gianHang =	gianHangStringCellEditEvent.getRowValue();
                GianHangTieuChuan ghtc = (GianHangTieuChuan) gianHang;
                ghtc.setChatLieuMaiChe(gianHangStringCellEditEvent.getNewValue());
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
	 		alert.setContentText("Đã thêm gian hàng mã \"" + input + "\"");
	 		alert.showAndWait();
	 	}
	
	@FXML
    public void addButtonClicked(ActionEvent event) throws Exception {
		GianHang ghtc = new GianHangTieuChuan();
		GianHangTieuChuan ghtc_down = (GianHangTieuChuan) ghtc;
		
		
		ghtc_down.setViTri(vt_input.getText());
		ghtc_down.setDienTich(Double.parseDouble(dt_input.getText()));
		ghtc_down.setChatLieuVachNgan(vach_input.getText());
		ghtc_down.setChatLieuMaiChe(mai_input.getText());
		ghtc_down.setPhanLoai("tc");
		if (ghtc_down.isRented()) ghtc_down.setTinhTrang("Not Available");
		else ghtc_down.setTinhTrang("Available");
		
		ghtc_down.setMaGianHang(maGH_input.getText());
		input = ghtc_down.getMaGianHang();
		
		boolean flag = false;
		int count = 0;
    	for (GianHang obj : Controller.bigList) {
    		if (obj.getMaGianHang().equals(ghtc_down.getMaGianHang())) {
    			showAlertF();
        		maGH_input.clear();
    			break;
    		}
    		count++;
    	}
    	if (count == Controller.bigList.size()) flag = true;
    	if (flag) {
    		Controller.bigList.add(ghtc);
			table.getItems().add(ghtc);
			   			
			showAlertT();
			maGH_input.clear();
			vt_input.clear();
			dt_input.clear();
			vach_input.clear();
			mai_input.clear();
    		
    	}
    	
    }

    @FXML
    public void deleteButtonClicked(ActionEvent event) throws Exception {
//    	ObservableList<GianHangTieuChuan> ghSelected, all;
//    	all = table.getItems();
//    	ghSelected = table.getSelectionModel().getSelectedItems();
//    	
//    	ghSelected.forEach(all::remove);
    	
    	GianHang ghSelected = table.getSelectionModel().getSelectedItem();
    	if (!ghSelected.isRented()) {
    		table.getItems().remove(ghSelected);
    		Controller.bigList.remove(ghSelected);
    	}
    	else showAlert_notDelete();
//    	GianHangTieuChuan.SO_GIAN_HANG_THUE--;
	}


}
