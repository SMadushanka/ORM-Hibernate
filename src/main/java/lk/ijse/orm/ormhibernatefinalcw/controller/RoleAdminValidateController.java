package lk.ijse.orm.ormhibernatefinalcw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

import java.io.IOException;

public class RoleAdminValidateController {

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private AnchorPane rolesvalidatePane;

    @FXML
    void gotoLandingPage(ActionEvent event) throws IOException {
        new WindowUtils().navigateTo("RolesView", rolesvalidatePane);
    }

    private final String email = "12";
    private final String password = "12";

    @FXML
    void validateAdmin(ActionEvent event) throws IOException {
        new WindowUtils().navigateTo("admin/AdminView", rolesvalidatePane);
    }
}
