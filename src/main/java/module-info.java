module dev.iesfranciscodelosrios.psp_async_navidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens dev.iesfranciscodelosrios.psp_async_navidad to javafx.fxml;
    exports dev.iesfranciscodelosrios.psp_async_navidad;
    exports dev.iesfranciscodelosrios.psp_async_navidad.Controller;
    opens dev.iesfranciscodelosrios.psp_async_navidad.Controller;

    exports dev.iesfranciscodelosrios.psp_async_navidad.Components;
    opens dev.iesfranciscodelosrios.psp_async_navidad.Components;

}
