module com.bgmea.matricoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bgmea.matricoperation to javafx.fxml;
    exports com.bgmea.matricoperation;
}