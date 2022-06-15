package View;

import Controller.PlayGameMenuController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Demographics {
    public static URL demographicsPageURL;
    public static Scene infoPanelScene;
    public static Stage stage;

    public Scene demographicsPageScene;

    public void start() throws IOException {

        String text = new PlayGameMenuController().demographics(InfoPanel.civilizations,InfoPanel.tiles).toString();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        String[] notes = text.split("\n");
        for(int i = 0; i < notes.length; i++){
            Text text1 = new Text(notes[i]);
            text1.setFont(new Font(15));
            vBox.getChildren().add(text1);
        }

        BorderPane root = FXMLLoader.load(demographicsPageURL);
        root.setCenter(vBox);

        demographicsPageScene = new Scene(root);
        stage.setScene(demographicsPageScene);
        stage.show();
    }

    public void backClicked(MouseEvent mouseEvent) throws IOException {
        new InfoPanel().start();
    }
}
