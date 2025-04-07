package lk.ijse.orm.ormhibernatefinalcw.controller.ricieption;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormhibernatefinalcw.dto.RicieptionDto;
//import lk.ijse.orm.ormhibernatefinalcw.dao.DaoFactory.Type;
import lk.ijse.orm.ormhibernatefinalcw.service.ServiceFactory.Type;
import lk.ijse.orm.ormhibernatefinalcw.service.ServiceFactory;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.RicieptionService;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

public class AddRicieptionController {

    RicieptionService ricieptionService = (RicieptionService) ServiceFactory.getInstance().getService(Type.RICIEPTION);

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private AnchorPane rolesvalidatePane;

    @FXML
    void gotoLandingPage(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("RolesView", rolesvalidatePane);
    }

    @FXML
    void validateAdmin(ActionEvent event) throws Exception{

        if (emailTxt.getText().isEmpty()) {
            new Alert(AlertType.ERROR, "Email Cannot be null !").show();
        }

        if (passwordTxt.getText().isEmpty()) {
            new Alert(AlertType.ERROR, "Password Cannot be null !").show();
        }

        Boolean resp = ricieptionService.addNewRicieption(
                new RicieptionDto(
                        emailTxt.getText(),
                        passwordTxt.getText()
                ));

        if (resp) {
            new Alert(AlertType.INFORMATION,"Ricieption Addedd Success !").show();
        } else {
            new Alert(AlertType.ERROR,"Ricieption Added Failed !").show();
        }

    }
}
