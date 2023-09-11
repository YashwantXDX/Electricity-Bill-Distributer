module com.myapp.electricity_bill_distributer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.myapp.electricity_bill_distributer to javafx.fxml;
    exports com.myapp.electricity_bill_distributer;
}