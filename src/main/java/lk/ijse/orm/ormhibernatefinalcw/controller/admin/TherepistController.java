package lk.ijse.orm.ormhibernatefinalcw.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import lk.ijse.orm.ormhibernatefinalcw.dto.ThereoistDto;
import lk.ijse.orm.ormhibernatefinalcw.dto.tm.TherepyTM;
import lk.ijse.orm.ormhibernatefinalcw.service.ServiceFactory;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.ProgrammeService;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.TherepistService;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TherepistController implements Initializable {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXComboBox<ProgrammeDto> programmeCmb;

    @FXML
    private TableColumn<TherepyTM, Integer> contactCol;

    @FXML
    private TextField contactTxt;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TableColumn<TherepyTM, Integer> idCol;

    @FXML
    private TableColumn<TherepyTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private TableColumn<TherepyTM, String> programmeCol;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TableView<TherepyTM> therepistTbl;

    @FXML
    private JFXButton updateBtn;

    TherepistService therepistService = (TherepistService) ServiceFactory.getInstance().getService(Type.THEREPIST);
    ProgrammeService programmeService = (ProgrammeService) ServiceFactory.getInstance().getService(Type.PROGRAMME);

    void getAllProgrammes() {

        ArrayList<ProgrammeDto> proDtos = programmeService.getAll();

        ObservableList<ProgrammeDto> programmeList = FXCollections.observableArrayList(proDtos);
        programmeCmb.setItems(programmeList);

        // Set how the items should be displayed in the ComboBox
        programmeCmb.setConverter(new javafx.util.StringConverter<ProgrammeDto>() {
            @Override
            public String toString(ProgrammeDto programme) {
                return programme != null ? programme.getName() : "";
            }

            @Override
            public ProgrammeDto fromString(String string) {
                return programmeCmb.getItems().stream()
                        .filter(prog -> prog.getName().equals(string))
                        .findFirst()
                        .orElse(null);
            }
        });
    }

    // this variable create get the programmeid(store therepist table programmeid)
    private static int id = 0;

    @FXML
    void addTherepist(ActionEvent event) throws Exception {

        ThereoistDto thereoistDto = new ThereoistDto();
        ProgrammeDto programmeDto = programmeService.search(id);

        thereoistDto.setName(nameTxt.getText());
        thereoistDto.setProID(programmeDto);
        thereoistDto.setContact(Integer.parseInt(contactTxt.getText()));

        boolean resp = therepistService.addTherepist(thereoistDto);

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Therepist Added Succes").show();
            clearFields();
            getAllTherepies();
            getAllProgrammes();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void clickCmb(ActionEvent event) {
        ProgrammeDto selectedProgramme = programmeCmb.getSelectionModel().getSelectedItem();

        if (selectedProgramme != null) {
            id = selectedProgramme.getId();
        }
    }

    @FXML
    void clickTbl(MouseEvent event) {
        saveBtn.setDisable(true);
        deleteBtn.setDisable(false);
        updateBtn.setDisable(false);

        TherepyTM therepyTM = therepistTbl.getSelectionModel().getSelectedItem();

        if (therepyTM != null) {
            nameTxt.setText(therepyTM.getName());
            contactTxt.setText(String.valueOf(therepyTM.getContact()));
            programmeCmb.setPromptText(therepyTM.getProName());
        }
    }

    @FXML
    void deleteTherepist(ActionEvent event) throws Exception{
        TherepyTM therepyTM = therepistTbl.getSelectionModel().getSelectedItem();

        int therepiId = therepyTM.getId();

        boolean resp = therepistService.deleteTherepy(therepiId);
        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Deleted Sucess !").show();
            getAllTherepies();
            clearFields();
            getAllProgrammes();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong").show();
        }
    }

    @FXML
    void updateTherepist(ActionEvent event) throws Exception{
        ThereoistDto thereoistDto = new ThereoistDto();
        ProgrammeDto programmeDto = programmeService.search(id);

        thereoistDto.setName(nameTxt.getText());
        thereoistDto.setProID(programmeDto);
        thereoistDto.setContact(Integer.parseInt(contactTxt.getText()));

        boolean resp = therepistService.updateTherepist(thereoistDto);

        if (resp){
            new Alert(Alert.AlertType.INFORMATION,"Therepist Added Succes").show();
            clearFields();
            getAllTherepies();
            getAllProgrammes();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong !").show();
        }
    }

    @FXML
    void gotoBack(ActionEvent event) throws Exception {
        new WindowUtils().navigateTo("admin/AdminView", pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            updateBtn.setDisable(true);
            deleteBtn.setDisable(true);

            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            programmeCol.setCellValueFactory(new PropertyValueFactory<>("proName"));
            contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

            getAllProgrammes();
            getAllTherepies();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getAllTherepies() {
        ArrayList<ThereoistDto> therepyDtos = therepistService.getAll();
        ObservableList<TherepyTM> theTMS = FXCollections.observableArrayList();

        for (ThereoistDto thereoistDto : therepyDtos) {
            ProgrammeDto programmeDto = thereoistDto.getProID(); // Get ProgrammeDto from ThereoistDto

            if (programmeDto != null) {
                theTMS.add(new TherepyTM(
                        thereoistDto.getId(),
                        thereoistDto.getName(),
                        programmeDto.getName(), // Get Programme ID correctly
                        thereoistDto.getContact()
                ));
            }
        }

        therepistTbl.setItems(theTMS);
    }

    void clearFields(){
        nameTxt.setText("");
        programmeCmb.getItems().clear();
        contactTxt.setText("");
        programmeCmb.setPromptText("");
        deleteBtn.setDisable(true);
        updateBtn.setDisable(true);
        saveBtn.setDisable(false);
    }
}