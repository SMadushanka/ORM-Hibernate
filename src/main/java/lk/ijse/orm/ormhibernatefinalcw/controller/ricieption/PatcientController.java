package lk.ijse.orm.ormhibernatefinalcw.controller.ricieption;

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
import lk.ijse.orm.ormhibernatefinalcw.dto.PatcientDto;
import lk.ijse.orm.ormhibernatefinalcw.dto.PaymentDto;
import lk.ijse.orm.ormhibernatefinalcw.dto.ProgrammeDto;
import lk.ijse.orm.ormhibernatefinalcw.dto.tm.PatcientTM;
import lk.ijse.orm.ormhibernatefinalcw.service.ServiceFactory;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.PatcientService;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.PaymentService;
import lk.ijse.orm.ormhibernatefinalcw.service.custom.ProgrammeService;
import lk.ijse.orm.ormhibernatefinalcw.utils.WindowUtils;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PatcientController implements Initializable {

    PatcientService patcientService = (PatcientService) ServiceFactory.getInstance().getService(ServiceFactory.Type.PATCIENT);
    ProgrammeService programmeService = (ProgrammeService) ServiceFactory.getInstance().getService(ServiceFactory.Type.PROGRAMME);
    PaymentService paymentService = (PaymentService) ServiceFactory.getInstance().getService(ServiceFactory.Type.PAYMENT);
    @FXML
    private TableColumn<PatcientTM, Integer> contactCol;

    @FXML
    private TextField amountTxt;

    @FXML
    private TextField contactTxt;

    @FXML
    private TableColumn<PatcientTM, String> emailCol;

    @FXML
    private TextField emailTxt;

    @FXML
    private TableColumn<PatcientTM, Integer> idCol;

    @FXML
    private TableColumn<PatcientTM, String> nameCol;

    @FXML
    private TextField nameTxt;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<PatcientTM> patTbl;

    @FXML
    private JFXComboBox<ProgrammeDto> proCmb;

    @FXML
    private TableColumn<PatcientTM, String> programmeCol;


    @FXML
    void addPatcient(ActionEvent event) throws Exception{

        ProgrammeDto programmeDto = programmeService.search(id);
        int paID = patcientService.saves(new PatcientDto(nameTxt.getText(),proCmb.getSelectionModel().getSelectedItem(),emailTxt.getText(),Integer.parseInt(contactTxt.getText())));
        boolean resp = paymentService.savePayment(new PaymentDto(
                LocalDate.now(),
                Double.parseDouble(amountTxt.getText()),
                paID,
                programmeDto.getId()
        ));

        if (resp) {
            new Alert(Alert.AlertType.INFORMATION,"Complete Registraion !").show();
            clearFields();
            getAll();
            getAllProgrammes();
        } else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong").show();
        }

        // ProgrammeDto programmeDto = programmeService.search(id);
        // PatcientDto patcientDto = new PatcientDto();

        // patcientDto.setName(nameTxt.getText());
        // patcientDto.setProgrammeDto(programmeDto);
        // patcientDto.setEmail(emailTxt.getText());
        // patcientDto.setContact(Integer.parseInt(contactTxt.getText()));

        // boolean resp = patcientService.addPatcient(patcientDto);

        // if (resp){
        //     PaymentDto paymentDto = new PaymentDto();

        //     if (patcientDto != null){

        //         PatcientDto patcientDto1 = patcientService.search(patcientDto.getId());

        //         paymentDto.setDate(LocalDate.now());
        //         paymentDto.setAmount(Double.parseDouble(amountTxt.getText()));
        //         paymentDto.setPatcient(patcientDto1);
        //         paymentDto.setProgramme(programmeDto);

        //         boolean nextResp = paymentService.savePayment(paymentDto);

        //         if (nextResp){
        //             new Alert(Alert.AlertType.INFORMATION,"Complete Registraion !").show();
        //             clearFields();
        //             getAllProgrammes();
        //             getAll();
        //         }else {
        //             new Alert(Alert.AlertType.ERROR,"Something Went Wrong!").show();
        //         }
        //     }
        // }else {
        //     new Alert(Alert.AlertType.ERROR,"Something Went Wrong!").show();
        // }
    }

    @FXML
    void deletePatcient(ActionEvent event) throws Exception{
        PatcientTM tm = patTbl.getSelectionModel().getSelectedItem();

        if (tm != null){
            boolean resp = patcientService.deletePatcient(tm.getId());

            if (resp){
                new Alert(Alert.AlertType.INFORMATION,"Delete Success!").show();
                clearFields();
                getAllProgrammes();
                getAll();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something Went Wrong!").show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong!").show();
        }
    }

    @FXML
    void updatePatcient(ActionEvent event) throws Exception{

    }

    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("ricieption/RicieptionView",pane);
    }

    public void getAll() throws Exception{
        ArrayList<PatcientDto> patcientDtos = patcientService.getAll();
        ObservableList<PatcientTM> theTMS = FXCollections.observableArrayList();

        for (PatcientDto patcientDto : patcientDtos) {
            ProgrammeDto programmeDto = patcientDto.getProgrammeDto(); // Get ProgrammeDto from ThereoistDto

            if (programmeDto != null) {
                theTMS.add(new PatcientTM(
                        patcientDto.getId(),
                        patcientDto.getName(),
                        patcientDto.getEmail(),
                        programmeDto.getName(), // Get Programme ID correctly
                        patcientDto.getContact()
                ));
            }
        }

        patTbl.setItems(theTMS);
    }

    @FXML
    void tblClick(MouseEvent event) {
        PatcientTM tm = patTbl.getSelectionModel().getSelectedItem();

        if (tm != null){
            nameTxt.setText(tm.getName());
            emailTxt.setText(tm.getProName());
            proCmb.setPromptText(tm.getEmail());
            contactTxt.setText(String.valueOf(tm.getContact()));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        programmeCol.setCellValueFactory(new PropertyValueFactory<>("proName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));

        try{
            getAll();
            getAllProgrammes();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void getAllProgrammes(){
        ArrayList<ProgrammeDto> proDtos = programmeService.getAll();

        ObservableList<ProgrammeDto> programmeList = FXCollections.observableArrayList(proDtos);
        proCmb.setItems(programmeList);

        proCmb.setConverter(new javafx.util.StringConverter<ProgrammeDto>() {
            @Override
            public String toString(ProgrammeDto programme) {
                return programme != null ? programme.getName() : "";
            }

            @Override
            public ProgrammeDto fromString(String string) {
                return proCmb.getItems().stream()
                        .filter(prog -> prog.getName().equals(string))
                        .findFirst()
                        .orElse(null);
            }
        });
    }

    private static int id = 0;
    private static int patId = 0;

    @FXML
    void selectProgramme(ActionEvent event) {
        ProgrammeDto selectedProgramme = proCmb.getSelectionModel().getSelectedItem();

        if (selectedProgramme != null) {
            id = selectedProgramme.getId();
        }
    }

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXButton updateBtn;

    void clearFields(){
        deleteBtn.setDisable(true);
        updateBtn.setDisable(true);
        addBtn.setDisable(false);
        nameTxt.setText("");
        emailTxt.setText("");
        contactTxt.setText("");
        amountTxt.setText("");
        proCmb.getItems().clear();
    }
}