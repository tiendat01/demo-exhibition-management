module com.example.demoexhibitionmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

//    opens com.example.demoexhibitionmanagement to javafx.fxml;
//    exports com.example.demoexhibitionmanagement;

    // add directory in resources to this:
    // .java source directory has the same name with directory containing layout .fxml:
    opens application to javafx.fxml;
    exports application;

    opens object to javafx.base;
    exports  object;
}