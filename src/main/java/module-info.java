module lk.ijse.orm.ormhibernatefinalcw {
    requires javafx.fxml;
    requires lombok;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires com.jfoenix;
    requires javafx.controls;
    requires mysql.connector.java;



    opens lk.ijse.orm.ormhibernatefinalcw.entity to org.hibernate.orm.core;
    opens lk.ijse.orm.ormhibernatefinalcw.config to jakarta.persistence;


    opens lk.ijse.orm.ormhibernatefinalcw to javafx.fxml;
    opens lk.ijse.orm.ormhibernatefinalcw.controller to javafx.fxml;
    opens lk.ijse.orm.ormhibernatefinalcw.controller.ricieption to javafx.fxml;
    opens lk.ijse.orm.ormhibernatefinalcw.dto to javafx.fxml;
    opens lk.ijse.orm.ormhibernatefinalcw.dto.tm to javafx.fxml;

    exports lk.ijse.orm.ormhibernatefinalcw;
    opens lk.ijse.orm.ormhibernatefinalcw.controller.admin to javafx.fxml;
}