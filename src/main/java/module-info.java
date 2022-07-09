module com.example.familiada {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.familiada to javafx.fxml;
    exports com.example.familiada;
}