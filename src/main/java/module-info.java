module com.example.javafxgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.javafxgame to javafx.fxml;
    exports com.example.javafxgame;
}