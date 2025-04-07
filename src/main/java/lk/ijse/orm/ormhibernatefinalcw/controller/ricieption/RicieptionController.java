package lk.ijse.orm.ormhibernatefinalcw.controller.ricieption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

public class RicieptionController {

    @FXML
    private AnchorPane pane;

    @FXML
    void addNewRicieption(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("ricieption/NewRicieptionView", pane);
    }

    @FXML
    void gotoLandingPage(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("RoleRicieptionView",pane);
    }

    @FXML
    void gotoPatientView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("ricieption/PatcienView",pane);
    }

    @FXML
    void gotoPaymentView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("ricieption/PaymentView",pane);
    }

    @FXML
    void gotoSessionView(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("ricieption/SessionView",pane);
    }

}

