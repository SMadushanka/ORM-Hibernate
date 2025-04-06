package lk.ijse.orm.ormhibernatefinalcw.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

import java.io.IOException;

public class LandingController {

    @FXML
    private AnchorPane mainPane;

    @FXML
    void gotoRegisterPage(ActionEvent event) throws IOException {
        new WindowUtils().navigateTo("RolesView", mainPane);
    }

}
