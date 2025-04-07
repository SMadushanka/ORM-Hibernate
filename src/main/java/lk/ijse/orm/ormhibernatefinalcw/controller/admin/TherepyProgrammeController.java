package lk.ijse.orm.ormhibernatefinalcw.controller.admin;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.orm.ormhibernatefinalcw.dto.ProgrammeDto;
import lk.ijse.orm.ormhibernatefinalcw.dto.tm.ProgrammeTM;
import lk.ijse.orm.ormhibernatefinalcw.service.ServiceFactory;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.ProgrammeService;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TherepyProgrammeController implements Initializable {

    ProgrammeService programmeService = (ProgrammeService) ServiceFactory.getInstance().getService(ServiceFactory.Type.PROGRAMME);

    @FXML
    private AnchorPane pane;

    @FXML
    private TableColumn<ProgrammeTM, String> durationCol;

    @FXML
    private TextField durationTxt;

    @FXML
    private TableColumn<ProgrammeTM, Double> feesCol;

    @FXML
    private TextField feesTxt;

    @FXML
    private TableColumn<ProgrammeTM, Integer> idCol;

    @FXML
    private TableColumn<ProgrammeTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableView<ProgrammeTM> progtammeTbl;

    @FXML
    void addProgramme(ActionEvent event) throws Exception {
        boolean resp = programmeService.addProgramme(new ProgrammeDto(
                nameTxt.getText(),
                durationTxt.getText(),
                Double.parseDouble(feesTxt.getText())
        ));

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Programme Added Success!").show();
            getAll();
            clearFields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong!").show();
        }
    }

    @FXML
    void deleteProgramme(ActionEvent event) throws Exception {
        ProgrammeTM programmeTM = progtammeTbl.getSelectionModel().getSelectedItem();

        if (programmeTM != null){
            int id = programmeTM.getId();
            boolean resp = programmeService.deleteProgramme(id);
            if (resp){
                new Alert(Alert.AlertType.INFORMATION,"Programme Deleted !").show();
                clearFields();
                getAll();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something Went Wrong").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Cannot Find This Programme").show();
        }
    }

    @FXML
    void tblClicked(MouseEvent event) {
        ProgrammeTM programmeTM = progtammeTbl.getSelectionModel().getSelectedItem();

        if (programmeTM != null){
            nameTxt.setText(programmeTM.getName());
            durationTxt.setText(programmeTM.getDuration());
            feesTxt.setText(String.valueOf(programmeTM.getFees()));
        }
    }

    @FXML
    void updtaeProgramme(ActionEvent event) {
        boolean resp = programmeService.updateProgramme(new ProgrammeDto(
                nameTxt.getText(),
                durationTxt.getText(),
                Double.parseDouble(feesTxt.getText())
        ));

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Programme Update Success!").show();
            getAll();
            clearFields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong!").show();
        }
    }


    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("admin/AdminView",pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        feesCol.setCellValueFactory(new PropertyValueFactory<>("fees"));

        try{
            getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void clearFields(){
        nameTxt.setText("");
        durationTxt.setText("");
        feesTxt.setText("");
    }

    void getAll(){
        ArrayList<ProgrammeDto>programmeDtos = programmeService.getAll();
        ObservableList<ProgrammeTM> proTMS = FXCollections.observableArrayList();

        for (ProgrammeDto programmeDto : programmeDtos){
            proTMS.add(new ProgrammeTM(
                    programmeDto.getId(),
                    programmeDto.getName(),
                    programmeDto.getDuration(),
                    programmeDto.getFees()
            ));
        }
        progtammeTbl.setItems(proTMS);
    }
}
