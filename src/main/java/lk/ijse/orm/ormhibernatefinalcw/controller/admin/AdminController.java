package lk.ijse.orm.ormhibernatefinalcw.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

public class AdminController {

    @FXML
    private AnchorPane pane;

    @FXML
    void addNewAdmin(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("admin/NewAdminView", pane);
    }

    @FXML
    void gotoLandingPage(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("RoleAdminView",pane);
    }

    @FXML
    void gotoTherepistView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("admin/TherepistView",pane);
    }

    @FXML
    void gotoTherepyProgrammesView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("admin/TherepyProgrammeView",pane);
    }
}