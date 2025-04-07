package lk.ijse.orm.ormhibernatefinalcw.controller.ricieption;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormhibernatefinalcw.dto.SessionDto;
import lk.ijse.orm.ormhibernatefinalcw.dto.ThereoistDto;
import lk.ijse.orm.ormhibernatefinalcw.dto.tm.SessionTM;
import lk.ijse.orm.ormhibernatefinalcw.service.ServiceFactory;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.SessionService;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.TherepistService;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TherepySessionController implements Initializable {

    SessionService sessionService = (SessionService) ServiceFactory.getInstance().getService(ServiceFactory.Type.THE_SESSION);
    TherepistService therepistService = (TherepistService) ServiceFactory.getInstance().getService(ServiceFactory.Type.THEREPIST);
    @FXML
    private AnchorPane pane;

    @FXML
    private TableColumn<SessionTM, String> TherepyCol;

    @FXML
    private TableColumn<SessionTM, LocalDate> dateCol;

    @FXML
    private DatePicker dateTxt;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<SessionTM, Integer> idCol;

    @FXML
    private TableColumn<SessionTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TableView<SessionTM> sessionTbl;

    @FXML
    private JFXComboBox<ThereoistDto> threpistCmb;

    @FXML
    private JFXButton updateBtn;

    @FXML
    void addSession(ActionEvent event) throws Exception {
        SessionDto dto = new SessionDto();
        ThereoistDto thereoistDto = therepistService.search(id);

        dto.setName(nameTxt.getText());
        dto.setDate(dateTxt.getValue());
        dto.setThereoistDto(thereoistDto);

        boolean resp = sessionService.addSession(dto);
        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Therepist Added Succes").show();
            clearFields();
            getAllTherepistNames();
            getAll();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void clickTbl(MouseEvent event) {
        saveBtn.setDisable(true);
        deleteBtn.setDisable(false);
        updateBtn.setDisable(false);

        SessionTM sessionTM = sessionTbl.getSelectionModel().getSelectedItem();

        if (sessionTM != null){
            nameTxt.setText(sessionTM.getName());
            dateTxt.setPromptText(String.valueOf(sessionTM.getDate()));
            threpistCmb.setPromptText(sessionTM.getTherepistName());
        }
    }

    @FXML
    void deleteSession(ActionEvent event) throws Exception {
        SessionTM sessionTM = sessionTbl.getSelectionModel().getSelectedItem();
        int sessionTMId = sessionTM.getId();

        boolean resp = sessionService.deleteSession(sessionTMId);

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Deleted Sucess !").show();
            clearFields();
            getAllTherepistNames();
            getAll();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong").show();
        }
    }

    @FXML
    void selectTherepist(ActionEvent event) {
        ThereoistDto selectTherepist = threpistCmb.getSelectionModel().getSelectedItem();
        if (selectTherepist != null){
            id = selectTherepist.getId();
        }
    }

    @FXML
    void updateSession(ActionEvent event) {
        SessionDto dto = new SessionDto();
        ThereoistDto thereoistDto = therepistService.search(id);

        dto.setName(nameTxt.getText());
        dto.setDate(dateTxt.getValue());
        dto.setThereoistDto(thereoistDto);

        boolean resp = sessionService.updateSession(dto);
        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Therepist Added Succes").show();
            clearFields();
            getAllTherepistNames();
            getAll();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }


    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("ricieption/RicieptionView",pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        deleteBtn.setDisable(true);
        updateBtn.setDisable(true);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        TherepyCol.setCellValueFactory(new PropertyValueFactory<>("therepistName"));

        try{
            getAllTherepistNames();
            getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int id = 0;

    void getAll(){

        ArrayList<SessionDto> sessionDtos = sessionService.getAll();
        ObservableList<SessionTM> sessionTMS = FXCollections.observableArrayList();

        for (SessionDto dto : sessionDtos){
            ThereoistDto thereoistDto = dto.getThereoistDto();

            if (thereoistDto != null){
                sessionTMS.add(new SessionTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getDate(),
                        thereoistDto.getName()
                ));
            }
        }
        sessionTbl.setItems(sessionTMS);
    }

    void getAllTherepistNames(){
        ArrayList<ThereoistDto> proDtos = therepistService.getAll();

        ObservableList<ThereoistDto> thereList = FXCollections.observableArrayList(proDtos);
        threpistCmb.setItems(thereList);

        // Set how the items should be displayed in the ComboBox
        threpistCmb.setConverter(new javafx.util.StringConverter<ThereoistDto>() {
            @Override
            public String toString(ThereoistDto dto) {
                return dto != null ? dto.getName() : "";
            }

            @Override
            public ThereoistDto fromString(String string) {
                return threpistCmb.getItems().stream()
                        .filter(prog -> prog.getName().equals(string))
                        .findFirst()
                        .orElse(null);
            }
        });
    }


    void clearFields(){
        saveBtn.setDisable(false);
        deleteBtn.setDisable(true);
        updateBtn.setDisable(true);
        nameTxt.setText("");
        dateTxt.getEditor().clear();
        threpistCmb.getItems().clear();
    }
}

