module com.example.integradora2discretas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.integradora2discretas to javafx.fxml;
    exports com.example.integradora2discretas;
    exports com.example.integradora2discretas.control;
    opens com.example.integradora2discretas.control to javafx.fxml;
}