module tpintegrador.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    
    opens tpintegrador.proyecto to javafx.fxml;
    exports tpintegrador.proyecto;
}
