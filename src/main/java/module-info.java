module com.example.ihm {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.ihm to javafx.fxml;
    exports vue;
    opens model to javafx.base;
}