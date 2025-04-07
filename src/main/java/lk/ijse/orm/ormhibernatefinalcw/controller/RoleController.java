package lk.ijse.orm.ormhibernatefinalcw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

public class RoleController {

    @FXML
    private AnchorPane rolesPane;

    @FXML
    void gotoLandingPage(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("Landing",rolesPane);
    }

    @FXML
    void gotoRicieptionValidateView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("RoleRicieptionView",rolesPane);
    }

    @FXML
    void gotoAdminValidateView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("RoleAdminView",rolesPane);
    }
}
