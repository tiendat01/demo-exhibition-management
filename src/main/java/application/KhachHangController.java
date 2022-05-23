/*
 * @author: Nguyen Tien Dat
 */

package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import object.GianHang;
import object.GianHangCaoCap;
import object.GianHangTieuChuan;
import object.KhachHang;

public class KhachHangController implements Initializable {
	@FXML
	private TableView<KhachHang> table;
	
	@FXML
    private TableColumn<KhachHang, Double> tiencol;

    @FXML
    private TableColumn<KhachHang, LocalDate> endDatecol;

    @FXML
    private TableColumn<KhachHang, String> diaChicol;

    @FXML
    private TableColumn<KhachHang, String> hoTencol;

    @FXML
    private TableColumn<KhachHang, String> maGHcol;

    @FXML
    private TableColumn<KhachHang, LocalDate> startDatecol;
    
    @FXML
    private DatePicker startDate_input;

    @FXML
    private DatePicker endDate_input;

    @FXML
    private TextField hoTen_input;

    @FXML
    private TextField diaChi_input;

    @FXML
    private TextField tien_input;

    @FXML
    private TextField maGH_input;
    
    @FXML
    private Button delete_button;

    @FXML
    private Button add_button;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// set cho cac column
		hoTencol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("ten"));
		diaChicol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("diaChi"));
		maGHcol.setCellValueFactory(new PropertyValueFactory<KhachHang, String>("maGianHangThue"));
		startDatecol.setCellValueFactory(new PropertyValueFactory<KhachHang, LocalDate>("thoiGianBatDau"));
		endDatecol.setCellValueFactory(new PropertyValueFactory<KhachHang, LocalDate>("thoiGianKetThuc"));
		tiencol.setCellValueFactory(new PropertyValueFactory<KhachHang, Double>("tienDatCoc"));
		
		// add data to column
		table.setItems(Controller.bigKH);
		
		// make the table be editable
		table.setEditable(true);
		hoTencol.setCellFactory(TextFieldTableCell.forTableColumn());
		hoTencol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<KhachHang, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<KhachHang, String> khachHangStringCellEditEvent) {
                KhachHang khachHang = khachHangStringCellEditEvent.getRowValue();
                khachHang.setTen(khachHangStringCellEditEvent.getNewValue());
            }
        });
		diaChicol.setCellFactory(TextFieldTableCell.forTableColumn());
		diaChicol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<KhachHang, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<KhachHang, String> khachHangStringCellEditEvent) {
                KhachHang khachHang = khachHangStringCellEditEvent.getRowValue();
                khachHang.setDiaChi(khachHangStringCellEditEvent.getNewValue());
            }
        });
		// maGHcol.setCellFactory(TextFieldTableCell.forTableColumn()); // ko dc edit ma gian hang
		tiencol.setCellFactory(TextFieldTableCell.<KhachHang, Double>forTableColumn(new DoubleStringConverter()));
		tiencol.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<KhachHang, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<KhachHang, Double> khachHangStringCellEditEvent) {
                KhachHang khachHang = khachHangStringCellEditEvent.getRowValue();
                khachHang.setTienDatCoc(khachHangStringCellEditEvent.getNewValue());
            }
        });
		
		DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		// Custom rendering of the table cell.
		startDatecol.setCellFactory(column -> {
		    return new TableCell<KhachHang, LocalDate>() {
		        @Override
		        protected void updateItem(LocalDate item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                // Format date.
		                setText(myDateFormatter.format(item));
		            }
		        }
		    };
		});
		
		endDatecol.setCellFactory(column -> {
		    return new TableCell<KhachHang, LocalDate>() {
		        @Override
		        protected void updateItem(LocalDate item, boolean empty) {
		            super.updateItem(item, empty);

		            if (item == null || empty) {
		                setText(null);
		            } else {
		                // Format date.
		                setText(myDateFormatter.format(item));
		            }
		        }
		    };
		});
		
		table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}
	
	// cho nay hoi loi
	String input;
	
	void showAlertF() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("ERROR ALERT");
		alert.setHeaderText("Error!!!");
		alert.setContentText("Mã gian hàng \"" + input + "\" không tồn tại hoặc đã được thuê. "	+ "\nVui lòng nhập lại mã gian hàng!!!");
		alert.showAndWait();
	}
	
	void showAlertT() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("CONFIMATION ALERT");
		alert.setHeaderText("Confirmation");
		alert.setContentText("Đã thêm khách hàng với mã \"" + input + "\" .");
		alert.showAndWait();
	}
	

    @FXML
    void addButtonClicked(ActionEvent event) throws Exception {
    	KhachHang kh = new KhachHang();
    	kh.setTen(hoTen_input.getText());
    	kh.setDiaChi(diaChi_input.getText());   	
    	kh.setTienDatCoc(Double.parseDouble(tien_input.getText()));
    	kh.setThoiGianBatDau(startDate_input.getValue());
    	kh.setThoiGianKetThuc(endDate_input.getValue());
    	
    	kh.setMaGianHangThue(maGH_input.getText());
    	input = kh.getMaGianHangThue();
    	
    	boolean flag = false;
    	for (GianHang obj : Controller.bigList) {
    		if (obj.getMaGianHang().equals(kh.getMaGianHangThue()) && !obj.isRented()) {
    			flag = true;
    			obj.setRented(true);
    			table.getItems().add(kh);
    			
    			if (obj.getPhanLoai().equals("tc")) GianHangTieuChuan.SO_GIAN_HANG_THUE++;
    			else if (obj.getPhanLoai().equals("cc")) GianHangCaoCap.SO_GIAN_HANG_THUE++;
    			   			
    			showAlertT();
    			hoTen_input.clear();
    			diaChi_input.clear();
    			tien_input.clear();
    			maGH_input.clear();
    			startDate_input.getEditor().clear();
    			endDate_input.getEditor().clear();
    			break;
    		}
    	}
    	
    	if (!flag) {
    		showAlertF();
    		maGH_input.clear();
    	}
    	
    }

    @FXML
    void deleteButtonClicked(ActionEvent event) throws Exception {
    	KhachHang khSelected = table.getSelectionModel().getSelectedItem();
    	table.getItems().remove(khSelected);
    	Controller.bigKH.remove(khSelected);
    	for (GianHang obj : Controller.bigList) {
    		if (obj.getMaGianHang().equals(khSelected.getMaGianHangThue())) {
    			obj.setRented(false);
    			if (obj.getPhanLoai().equals("tc")) GianHangTieuChuan.SO_GIAN_HANG_THUE--;
    			else if (obj.getPhanLoai().equals("cc")) GianHangCaoCap.SO_GIAN_HANG_THUE--;
    			break;
    		}
    	}
    }

}
