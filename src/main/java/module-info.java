module dev.iesfranciscodelosrios.psp_async_navidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens dev.iesfranciscodelosrios.psp_async_navidad to javafx.fxml;
    exports dev.iesfranciscodelosrios.psp_async_navidad;
}
