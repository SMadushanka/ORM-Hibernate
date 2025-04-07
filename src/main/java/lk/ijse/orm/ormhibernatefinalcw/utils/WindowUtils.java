package lk.ijse.orm.ormhibernatefinalcw.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WindowUtils {
    public void navigateTo(String fxmlPath, AnchorPane paneName) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/"+fxmlPath+".fxml"));
        paneName.getChildren().setAll(pane);
    }
}
